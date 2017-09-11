import driverfactory.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestSetup {

    protected WebDriver driver;
    protected String baseUrl;

    @Before
    public void SetUp() {
        driver = new DriverFactory().create();
        baseUrl = "http://52.17.197.56:8080/bugzilla/";
    }

    @After
    public void TearDown() {
        driver.quit();
    }

}
