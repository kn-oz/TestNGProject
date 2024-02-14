package UI_Project;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

public class US_001 {

    SoftAssert softAssert = new SoftAssert();

    //US_001	Ziyaretçi olarak ana sayfaya erişebilmeliyim.

    @Test
    public void AnaSayfaGirisTest() {


        Driver.getDriver().get(ConfigReader.getProperty("jobExUrl"));

        String expectedUrl = ConfigReader.getProperty("jobExUrl");
        String actualUrl = Driver.driver.getCurrentUrl();

        softAssert.assertEquals(actualUrl, expectedUrl);

        softAssert.assertAll("Ziyaretçi olarak ana sayfaya erişilemedi");


        Driver.quitDriver();


    }
}
