package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DescribeComponentPage extends PageObject {

    @FindBy(how = How.LINK_TEXT, using = "TestComponent")
    private WebElement testComponent;

    public DescribeComponentPage(WebDriver driver)
    {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".component_name")));
    }

    public BugListPage clickComponent() {
        testComponent.click();

        return new BugListPage(driver);
    }

}
