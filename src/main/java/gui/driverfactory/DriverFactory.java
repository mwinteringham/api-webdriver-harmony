package gui.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public WebDriver create() {
        //If you don't have ChromeDriver on your path, then uncomment the lines relevant to your OS

        //OSX
        String pathToChromeDriver = System.getProperty("user.dir") + "/src/main/java/gui/driverfactory/osx/chromedriver";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        //Windows
        //String pathToChromeDriver = System.getProperty("user.dir") + "C:\\SomePathToSomewhere\\Path";
        //System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        return new ChromeDriver();
    }
}
