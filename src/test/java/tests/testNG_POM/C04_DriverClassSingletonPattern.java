package tests.testNG_POM;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DriverClassSingletonPattern {

    @Test
    public void test01(){





        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //Driver obj = new Driver();
        //obj.driver.get(ConfigReader.getProperty("toUrl"));






    }
}
