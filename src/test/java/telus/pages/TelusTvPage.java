package telus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import telus.config.ExpectedValues;

import java.time.Duration;
import java.util.List;

public class TelusTvPage {

    protected WebDriver driver;
    JavascriptExecutor js;

    public TelusTvPage(WebDriver driver) {
        this.driver = driver;
    }

    By popUpButton = By.cssSelector("#onboardingModal > div > div > div.welcome-slide-container > span");
    By demandButton = By.cssSelector("#root > div.site-header > div.top-nav > div.display-flex.align-center > header > ul > li:nth-child(3) > a");
    By allButton = By.cssSelector("#root > div.home > div:nth-child(16) > div.header > div > a");
    By filterButton = By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[1]/div");
    By animatedButton = By.xpath("//*[@id='root']/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/label");
    By applyButton = By.cssSelector("#root > div.view-all-wrapper > div.sort-filters > div.popUpContainer.viewAllFilter > div.filter-buttons > div.filter-button.filter-apply-button.filter-button-enabled");
    By assetFindAdultRating = By.xpath("//p[@class='subtitle' and text()='18+']");
    By selectAdultRating = By.xpath("//*[@id='root']/div[2]/div[1]/div[2]/div/div[1]/div/h2/span[1]");
    By scrollElement = By.cssSelector("#root > div.home > div:nth-child(16) > div.header > div > a");

    String arguments = "arguments[0].scrollIntoView(true);";

    public void closePopUp() {
        try {
            WebElement closePopupButton = waitForWebElement(popUpButton, ExpectedValues.TIME_SECONDS);
            closePopupButton.click();
        } catch (Exception e) {
            // Popup may not be present, ignore
        }
    }

    public void clickOnDemandButton() {
        WebElement onDemandButton = waitForWebElement(demandButton, ExpectedValues.TIME_SECONDS);
        onDemandButton.click();
    }

    public void ScrollToMovies() {
        WebElement element = waitForWebElement(scrollElement, ExpectedValues.TIME_SECONDS);
        js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript(arguments, element);
    }

    public void clickViewAllButton() {
        WebElement viewAllButton = waitForWebElement(allButton, ExpectedValues.TIME_SECONDS);
        viewAllButton.click();
    }

    public void clickFilterButton() {
        WebElement selectFilterButton = waitForWebElement(filterButton, ExpectedValues.TIME_SECONDS);
        selectFilterButton.click();
    }

    public void clickAnimatedOption() {
        WebElement animatedOption = waitForWebElement(animatedButton, ExpectedValues.TIME_SECONDS);
        animatedOption.click();
    }

    public void clickApplyOption() {
        WebElement applyOption = waitForWebElement(applyButton, ExpectedValues.TIME_SECONDS);
        applyOption.click();
    }

    public void findAdultRating() {
        WebElement adultPlusAsset = waitForWebElement(assetFindAdultRating, ExpectedValues.TIME_SECONDS);
        adultPlusAsset.click();
    }

    public String getDetailsRating() {
        WebElement ratingElement = waitForWebElement(selectAdultRating, ExpectedValues.TIME_SECONDS);
        String ratingText = ratingElement.getText();

        // Split the text by "|" and get the first part (which is "18+"), and trim it to remove extra spaces.
        String rating = ratingText.split("\\|")[0].trim();

        return rating;
    }

    private WebElement waitForWebElement(By byElement, int seconds){
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(byElement));
    }

}
