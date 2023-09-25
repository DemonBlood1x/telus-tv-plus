package telus.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {

    public static WebDriver chromeDriverConnection(ChromeOptions chromeOptions) {
//        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("disable-gpu");

        return new ChromeDriver(chromeOptions);
    }
}
