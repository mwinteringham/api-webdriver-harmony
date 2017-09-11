package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    public WebDriver create() {
        //If you don't have ChromeDriver on your path, then uncomment the lines relevant to your OS

        //OSX
        String pathToChromeDriver = System.getProperty("user.dir") + "/src/main/java/driverfactory/osx/chromedriver";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        //Windows
        //String pathToChromeDriver = System.getProperty("user.dir") + "C:\\SomePathToSomewhere\\Path";
        //System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        return new ChromeDriver();
    }
}
