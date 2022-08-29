package ui.test;

import org.junit.Assert;
import org.junit.Test;
import page.SearchPage;
import ui.step.SearchPageStep;
import utils.RandomUtils;

import static utils.Constants.EXPECTED_ERROR_SEARCH_MESSAGE;
import static utils.Constants.PRODUCT_ID;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchWithProductID(){
        Assert.assertTrue(new SearchPageStep().hasSearchItemInResult(PRODUCT_ID));
    }

    @Test
    public void testSearchWithIncorrectQuery(){
        Assert.assertFalse(new SearchPageStep().hasSearchItemInResult(RandomUtils.generateRandomSting()));
        Assert.assertEquals(EXPECTED_ERROR_SEARCH_MESSAGE, new SearchPage().getMessageNoResults());
    }
}
