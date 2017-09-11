import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import pageobjects.*;

import static org.hamcrest.core.IsEqual.equalTo;

public class BugPageTest extends TestSetup {

    @Test
    public void CheckForBugCreation(){
        driver.navigate().to(baseUrl);

        // Login
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickLogInLink();
        mainPage.PopulateEmailAddress("admin@bugzilla.org");
        mainPage.PopulatePassword("password");
        mainPage.ClickLogin();

        // Create bug
        EnterBugPage enterBugPage = mainPage.ClickNewBug();
        enterBugPage.SelectComponent("TestComponent");
        enterBugPage.SelectVersion("unspecified");
        enterBugPage.SelectSeverity("minor");
        enterBugPage.SelectHardware("PC");
        enterBugPage.SelectOS("Mac OS");
        enterBugPage.PopulateSummary("This is a minor bug");
        enterBugPage.PopulateDescription("This is a minor description");
        enterBugPage.ClickSubmitBug();

        // Navigate to bug
        DescribeComponentPage describeComponentPage = mainPage.clickBrowse();
        BugListPage bugListPage = describeComponentPage.clickComponent();
        BugPage bugPage = bugListPage.clickLatestBug();

        // Assert bug details
        Assert.assertThat(bugPage.ReadStatus(), Is.is(equalTo("CONFIRMED (edit)")));
        Assert.assertThat(bugPage.ReadComponent(), Is.is(equalTo("TestComponent")));
        Assert.assertThat(bugPage.ReadHardware(), Is.is(equalTo("PC")));
        Assert.assertThat(bugPage.ReadOS(), Is.is(equalTo("Mac OS")));
        Assert.assertThat(bugPage.ReadDescription(), Is.is(equalTo("This is a minor description")));
    }

}
