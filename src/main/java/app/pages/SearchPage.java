package app.pages;

import baseWebSetup.BaseSetup;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;
import java.util.stream.IntStream;

import static app.pages.SearchPageLocators.*;

@Slf4j
public class SearchPage extends BaseSetup {

    public void verifyThatCookiesPageIsOpen() {
        log.info("Verify That Cookies Page Is Opened");
        assert driver.findElement(By.cssSelector(COOKIES_PAGE_HEADER)).isDisplayed();
    }

    public void clickAcceptCookiesButton() {
        log.info("Click Accept Cookies Button");
        driver.findElement(By.xpath(ACCEPT_COOKIES_BUTTON)).click();
    }

    public void verifyGoogleSearchPageIsOpened() {
        log.info("Verify that Google Search Page is opened");
        assert driver.findElement(By.cssSelector(SEARCH_FIELD)).isDisplayed();
    }

    public void enterSearchValue(String value) {
        log.info("Start search by entering " + value);
        driver.findElement(By.cssSelector(SEARCH_FIELD)).sendKeys(value);

    }

    public void verifySearchResults(String value) {
        log.info("Verify search results contain word " + value);
        List<WebElement> results = driver.findElements(By.cssSelector(SEARCH_RESULT));
        IntStream.range(0, results.size()).forEach(i -> Assert.assertTrue(results.get(i).getText().contains(value), "Search result validation failed in [ + i + ]."));
    }

    public  void verifySuggestionList() {
        log.info("Verify that suggestion dropdown is opened");
        assert driver.findElement(By.cssSelector(AUTOCOMPLETE_DROPDOWN)).isDisplayed();
    }

    public void verifyResultInDropdown(String value) {
        log.info("Verify that suggestion dropdown contain value " + value);
        List<WebElement> results = driver.findElements(By.cssSelector(AUTOCOMPLETE_DROPDOWN));
        IntStream.range(0, results.size()).forEach(i -> Assert.assertTrue(results.get(i).getText().contains(value),
                "Search result validation failed in [ + i + ]."));
    }

    public void clickGoogleSearchButton() {
        log.info("Click Google Search Button");
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
    }


    public void setFocusIntoSearchField() {
        log.info("Set Focus into Search field");
        driver.findElement(By.cssSelector(SEARCH_FIELD)).click();
    }

    public  void pressEnterButton() {
        log.info("Press Enter button");
        driver.findElement(By.cssSelector(SEARCH_FIELD)).sendKeys(Keys.ENTER);
    }

    public  void verifySearchResultPageIsEmpty() {
        log.info("Verify Search Results page is Empty");
        Assert.assertFalse(checkVisibilityofElement(SEARCH_RESULT));
    }


    public boolean checkVisibilityofElement(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
