package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BugListPage extends PageObject {

    @FindBy(how = How.CSS, using = ".bz_buglist > tbody > tr:last-child .first-child a")
    private WebElement linkLatestBug;

    public BugListPage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_description_controller")));
    }

    public BugPage clickLatestBug() {
        linkLatestBug.click();

        return new BugPage(driver);
    }
    
}
