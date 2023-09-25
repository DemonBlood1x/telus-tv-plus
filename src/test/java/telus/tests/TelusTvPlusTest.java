package telus.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telus.config.ChromeBrowser;
import telus.config.ExpectedValues;
import telus.config.TelusURLConfig;
import telus.pages.TelusTvPage;


public class TelusTvPlusTest {
    private WebDriver driver;
    private TelusTvPage tvPage;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = ChromeBrowser.chromeDriverConnection(new ChromeOptions());
        tvPage = new TelusTvPage(driver);
        driver.get(TelusURLConfig.BASE_TELUS_TV_URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testTelusTvPlus() {
        tvPage.closePopUp();
        tvPage.clickOnDemandButton();
        tvPage.ScrollToMovies();
        tvPage.clickViewAllButton();
        tvPage.clickFilterButton();
        tvPage.clickAnimatedOption();
        tvPage.clickApplyOption();
        tvPage.findAdultRating();

        String adultContentAsset = tvPage.getDetailsRating();

        Assert.assertEquals(adultContentAsset, ExpectedValues.ADULT_CONTENT);
    }
}