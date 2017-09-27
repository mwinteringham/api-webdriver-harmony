package gui.helpers;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class LoginManager {

    private WebDriver driver;

    public LoginManager(WebDriver webDriver)
    {
        driver = webDriver;
    }

    public void setLoginCookies(String token){
        Cookie cookie = new Cookie("Bugzilla_logincookie", token);
        Cookie cookie1 = new Cookie("Bugzilla_login", "1");
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(cookie1);
    }

}
