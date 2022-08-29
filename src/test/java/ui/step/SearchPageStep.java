package ui.step;

import io.qameta.allure.Step;
import page.HomePage;
import page.SearchPage;

public class SearchPageStep extends SearchPage {

    @Step("Open search, type query in input, check result")
    public boolean hasSearchItemInResult(String query) {
        return new HomePage().openPage()
                .openMultiSearchFrame()
                .typeSearchInput(query)
                .hasItemInResultList(query);
    }
}
