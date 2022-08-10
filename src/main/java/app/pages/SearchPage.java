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

    public static void verifyThatCookiesPageIsOpen() {
        log.info("Verify That Cookies Page Is Opened");
        assert driver.findElement(By.cssSelector(COOKIES_PAGE_HEADER)).isDisplayed();
    }

    public static void clickAcceptCookiesButton() {
        log.info("Click Accept Cookies Button");
        driver.findElement(By.xpath(ACCEPT_COOKIES_BUTTON)).click();
    }

    public static void verifyGoogleSearchPageIsOpened() {
        log.info("Verify that Google Search Page is opened");
        assert driver.findElement(By.cssSelector(SEARCH_FIELD)).isDisplayed();
    }

    public static void enterSearchValue(String value) {
        log.info("Start search by entering " + value);
        driver.findElement(By.cssSelector(SEARCH_FIELD)).sendKeys(value);

    }

    public static void verifySearchResults(String value) {
        log.info("Verify search results contain word " + value);
        List<WebElement> results = driver.findElements(By.cssSelector(SEARCH_RESULT));
        IntStream.range(0, results.size()).forEach(i -> Assert.assertTrue(results.get(i).getText().contains(value), "Search result validation failed in [ + i + ]."));
    }

    public static void verifySuggestionList() {
        log.info("Verify that suggestion dropdown is opened");
        assert driver.findElement(By.cssSelector(AUTOCOMPLETE_DROPDOWN)).isDisplayed();
    }

    public static void verifyResultInDropdown(String value) {
        log.info("Verify that suggestion dropdown contain value " + value);
        List<WebElement> results = driver.findElements(By.cssSelector(AUTOCOMPLETE_DROPDOWN));
        IntStream.range(0, results.size()).forEach(i -> Assert.assertTrue(results.get(i).getText().contains(value),
                "Search result validation failed in [ + i + ]."));
    }

    public static void clickGoogleSearchButton() {
        log.info("Click Google Search Button");
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
    }


    public static void setFocusIntoSearchField() {
        log.info("Set Focus into Search field");
        driver.findElement(By.cssSelector(SEARCH_FIELD)).click();
    }

    public static void pressEnterButton() {
        log.info("Press Enter button");
        driver.findElement(By.cssSelector(SEARCH_FIELD)).sendKeys(Keys.ENTER);
    }

    public static void verifySearchResultPageIsEmpty() {
        log.info("Verify Search Results page is Empty");
        boolean present;
        try {
            driver.findElement(By.cssSelector(SEARCH_RESULT));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        Assert.assertFalse(present, "Search Page is not empty!");
    }

}
