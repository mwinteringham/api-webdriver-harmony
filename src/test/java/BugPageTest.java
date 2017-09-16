import gui.pageobjects.BugListPage;
import gui.pageobjects.BugPage;
import gui.pageobjects.DescribeComponentPage;
import gui.pageobjects.MainPage;
import http.Bug;
import http.payloads.request.BugPayload;
import http.payloads.response.BugResponsePayload;
import io.restassured.response.Response;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class BugPageTest extends TestSetup {

    private BugResponsePayload bugResponsePayload;

    @Before
    public void CreateBugForTesting() {
        // Create bug
        BugPayload bugPayload = new BugPayload("TestProduct", "TestComponent", "testing", "unspecified", "Mac OS", "PC", "This is a minor description");
        bugResponsePayload = Bug.postBug(bugPayload).as(BugResponsePayload.class);
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
        driver.navigate().to(baseUrl + "show_bug.cgi?id=" + bugResponsePayload.getId());
        BugPage bugPage = new BugPage(driver);

        // Assert bug details
        Assert.assertThat(bugPage.ReadStatus(), Is.is(equalTo("CONFIRMED (edit)")));
        Assert.assertThat(bugPage.ReadComponent(), Is.is(equalTo("TestComponent")));
        Assert.assertThat(bugPage.ReadHardware(), Is.is(equalTo("PC")));
        Assert.assertThat(bugPage.ReadOS(), Is.is(equalTo("Mac OS")));
        Assert.assertThat(bugPage.ReadDescription(), Is.is(equalTo("This is a minor description")));
    }

}