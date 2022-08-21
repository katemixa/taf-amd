package ui;

import org.junit.After;
import ui.driver.DriverSingleton;

public class BaseTest {

    @After
    public void finishTest() {
        DriverSingleton.closeDriver();
    }
}