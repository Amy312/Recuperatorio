package webUI.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IBrowser {
    @Override
    public WebDriver create() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/firefox/geckodriver.exe");
        FirefoxDriver firefox = new FirefoxDriver();
        return firefox;
    }
}
