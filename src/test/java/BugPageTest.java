import gui.pageobjects.BugListPage;
import gui.pageobjects.BugPage;
import gui.pageobjects.DescribeComponentPage;
import gui.pageobjects.MainPage;
import http.Bug;
import http.payloads.BugPayload;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class BugPageTest extends TestSetup {

    @Before
    public void CreateBugForTesting() {
        // Create bug
        BugPayload bugPayload = new BugPayload("TestProduct", "TestComponent", "testing", "unspecified", "Mac OS", "PC", "This is a minor description");
        Bug.postBug(bugPayload);
    }

    @Test
    public void TestForBugValues() {
        driver.navigate().to(baseUrl);

        // Login
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickLogInLink();
        mainPage.PopulateEmailAddress("admin@bugzilla.org");
        mainPage.PopulatePassword("password");
        mainPage.ClickLogin();

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