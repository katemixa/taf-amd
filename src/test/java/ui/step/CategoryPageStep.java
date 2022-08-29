package ui.step;

import io.qameta.allure.Step;
import page.CategoryPage;

public class CategoryPageStep extends CategoryPage {

    @Step("Select brand and check all product")
    public boolean selectBrandAndCheckTitles(){
        return new MenuBlockStep().openRandomCategory()
                .clickBrand()
                .checkProductWithClickedBrand();
    }
}
