package ui.step;

import io.qameta.allure.Step;
import page.CategoryPage;
import page.HomePage;
import page.MenuBlock;

public class MenuBlockStep extends MenuBlock {

    @Step("Open random category")
    public CategoryPage openRandomCategory() {
        new HomePage().openPage();
        return new MenuBlock().clickMainMenuItem()
                .clickSubMenuItem()
                .clickCategoryItem();
    }
}
