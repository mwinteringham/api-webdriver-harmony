import gui.helpers.LoginManager;
import gui.pageobjects.BugPage;
import http.api.Bug;
import http.api.Login;
import http.payloads.request.BugPayload;
import http.payloads.request.LoginPayload;
import http.payloads.response.BugResponsePayload;
import io.restassured.response.Response;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;

public class BugPageTest extends TestSetup {

    private BugResponsePayload bugResponsePayload;

    @Before
    public void CreateBugForTesting() {
        driver.navigate().to(baseUrl);

        // Login
        Map<String, String> payload = new LoginPayload("admin@bugzilla.org", "password").build();
        Response login = Login.postLogin(payload);

        String loginCookieToken = login.getCookie("Bugzilla_logincookie");

        LoginManager loginManager = new LoginManager(driver);
        loginManager.setLoginCookies(loginCookieToken);

        // Create bug
        BugPayload bugPayload = new BugPayload("TestProduct", "TestComponent", "testing", "unspecified", "Mac OS", "PC", "This is a minor description");
        bugResponsePayload = Bug.postBug(bugPayload).as(BugResponsePayload.class);
    }

    @Test
    public void TestForBugValues() {
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