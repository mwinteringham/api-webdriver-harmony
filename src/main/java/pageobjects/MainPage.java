package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageObject {

    @FindBy(how = How.LINK_TEXT, using = "New")
    private WebElement linkNew;

    @FindBy(how = How.LINK_TEXT, using = "Browse")
    private WebElement linkBrowse;

    @FindBy(how = How.LINK_TEXT, using = "Log In")
    private WebElement linkLogin;

    @FindBy(how = How.ID, using = "Bugzilla_login_top")
    private WebElement txtEmailAddress;

    @FindBy(how = How.ID, using = "Bugzilla_password_top")
    private WebElement txtPassword;

    @FindBy(how = How.ID, using = "log_in_top")
    private WebElement btnLogin;

    public MainPage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("enter_bug")));
    }

    public void ClickLogInLink() {
        linkLogin.click();
    }

    public void PopulateEmailAddress(String email) {
        txtEmailAddress.sendKeys(email);
    }

    public void PopulatePassword(String password) {
        txtPassword.sendKeys(password);
    }

    public MainPage ClickLogin() {
        btnLogin.click();
        return new MainPage(driver);
    }

    public EnterBugPage ClickNewBug() {
        linkNew.click();
        return new EnterBugPage(driver);
    }

    public DescribeComponentPage clickBrowse() {
        linkBrowse.click();

        return new DescribeComponentPage(driver);
    }

}
