package googleSearchProject;

import app.pages.SearchPage;
import baseWebSetup.BaseSetup;
import org.testng.annotations.Test;

//This set of tests is performed by user without logging in into his google account
public class GoogleSearchAnonymousUserTests extends BaseSetup {

String searchParameter = "Appian";

    @Test(description = "Verify that user is able to perform search from main page and search result contains entered word")
    void verifyThatSearchIsPossible() {
        SearchPage.verifyThatCookiesPageIsOpen();
        SearchPage.clickAcceptCookiesButton();
        SearchPage.verifyGoogleSearchPageIsOpened();
        SearchPage.enterSearchValue(searchParameter);
        SearchPage.clickGoogleSearchButton();
        SearchPage.verifySearchResults(searchParameter);
    }

    @Test(description = "Verify that list suggestion is opened in drop down when user enters value and don't press Enter")
    void verifyListOfSuggestions(){
        SearchPage.verifyThatCookiesPageIsOpen();
        SearchPage.clickAcceptCookiesButton();
        SearchPage.verifyGoogleSearchPageIsOpened();
        SearchPage.enterSearchValue(searchParameter);
        SearchPage.verifySuggestionList();
        SearchPage.verifyResultInDropdown(searchParameter);
    }


    @Test(description = "Verify that search is not search is not started when user clicks Search button without entering any value")
    void verifyNoSearchCanBeStartedEWithEmptySearchField(){
        SearchPage.verifyThatCookiesPageIsOpen();
        SearchPage.clickAcceptCookiesButton();
        SearchPage.verifyGoogleSearchPageIsOpened();
        SearchPage.verifyGoogleSearchButtonIsNotInteractable();
        SearchPage.verifySearchResultPageIsNotShown();
    }

}
