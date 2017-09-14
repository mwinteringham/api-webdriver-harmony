package gui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BugPage extends PageObject {

    @FindBy(how = How.ID, using = "static_bug_status")
    private WebElement lblStatus;

    @FindBy(how = How.ID, using = "component")
    private WebElement selComponent;

    @FindBy(how = How.ID, using = "rep_platform")
    private WebElement selHardware;

    @FindBy(how = How.ID, using = "op_sys")
    private WebElement selOs;

    @FindBy(how = How.ID, using = "comment_text_0")
    private WebElement lblFirstComment;


    public BugPage(WebDriver driver)
    {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bugzilla-body")));
    }

    public String ReadStatus() {
        return lblStatus.getText();
    }

    public String ReadComponent() {
        Select select = new Select(selComponent);
        return select.getFirstSelectedOption().getText();
    }

    public String ReadHardware() {
        Select select = new Select(selHardware);
        return select.getFirstSelectedOption().getText();
    }

    public String ReadOS() {
        Select select = new Select(selOs);
        return select.getFirstSelectedOption().getText();
    }

    public String ReadDescription() {
        return lblFirstComment.getText();
    }

}
