package ui.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import driver.DriverSingleton;

public class BaseTest {

    public static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @After
    public void tearDown() {
        LOGGER.info("Quit from driver");
        DriverSingleton.closeDriver();
    }
}