package ui.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ui.step.CategoryPageStep;

public class MenuTest extends BaseTest {

    @Ignore
    @Test
    public void testVerifyBrandInAllProducts() {
        Assert.assertTrue(new CategoryPageStep().selectBrandAndCheckTitles());
    }
}
