package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterBugPage extends PageObject {

    @FindBy(how = How.ID, using = "component")
    private WebElement selComponent;

    @FindBy(how = How.ID, using = "version")
    private WebElement selVersion;

    @FindBy(how = How.ID, using = "bug_severity")
    private WebElement selSeverity;

    @FindBy(how = How.ID, using = "rep_platform")
    private WebElement selHardware;

    @FindBy(how = How.ID, using = "op_sys")
    private WebElement selOs;

    @FindBy(how = How.ID, using = "short_desc")
    private WebElement txtSummary;

    @FindBy(how = How.ID, using = "comment")
    private WebElement txtDescription;

    @FindBy(how = How.ID, using = "commit")
    private WebElement btnSubmitBug;


    public EnterBugPage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bugzilla-body")));
    }

    public void SelectComponent(String component) {
        Select select = new Select(selComponent);
        select.selectByVisibleText(component);
    }

    public void SelectVersion(String version) {
        Select select = new Select(selVersion);
        select.selectByVisibleText(version);
    }

    public void SelectSeverity(String severity) {
        Select select = new Select(selSeverity);
        select.selectByVisibleText(severity);
    }

    public void SelectHardware(String hardware) {
        Select select = new Select(selHardware);
        select.selectByVisibleText(hardware);
    }

    public void SelectOS(String os) {
        Select select = new Select(selOs);
        select.selectByVisibleText(os);
    }

    public void PopulateSummary(String summary) {
        txtSummary.sendKeys(summary);
    }

    public void PopulateDescription(String description) {
        txtDescription.sendKeys(description);
    }

    public BugPage ClickSubmitBug() {
        btnSubmitBug.click();
        return new BugPage(driver);
    }

}
