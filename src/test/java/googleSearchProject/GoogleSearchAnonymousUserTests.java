package googleSearchProject;

import app.pages.SearchPage;
import baseWebSetup.BaseSetup;
import org.testng.annotations.Test;

//This set of tests is performed by user without logging in into his google account
public class GoogleSearchAnonymousUserTests extends BaseSetup {

String searchParameter = "Appian";

SearchPage searchPage = new SearchPage();

    @Test(description = "Verify that user is able to perform search from main page and search result contains entered word")
    void verifyThatSearchIsPossible() {
        searchPage.verifyThatCookiesPageIsOpen();
        searchPage.clickAcceptCookiesButton();
        searchPage.verifyGoogleSearchPageIsOpened();
        searchPage.enterSearchValue(searchParameter);
        searchPage.clickGoogleSearchButton();
        searchPage.verifySearchResults(searchParameter);
    }

    @Test(description = "Verify that list suggestion is opened in drop down when user enters value and don't press Enter")
    void verifyListOfSuggestions(){
        searchPage.verifyThatCookiesPageIsOpen();
        searchPage.clickAcceptCookiesButton();
        searchPage.verifyGoogleSearchPageIsOpened();
        searchPage.enterSearchValue(searchParameter);
        searchPage.verifySuggestionList();
        searchPage.verifyResultInDropdown(searchParameter);
    }


    @Test(description = "Verify that search is not search is not started when user clicks Search button without entering any value")
    void verifyNoSearchCanBeStartedEWithEmptySearchField(){
        searchPage.verifyThatCookiesPageIsOpen();
        searchPage.clickAcceptCookiesButton();
        searchPage.verifyGoogleSearchPageIsOpened();
        searchPage.setFocusIntoSearchField();
        searchPage.pressEnterButton();
        searchPage.verifySearchResultPageIsEmpty();
    }

}
