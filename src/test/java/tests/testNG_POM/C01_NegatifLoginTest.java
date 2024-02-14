package tests.testNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import pages.TestotomasyonFormPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_NegatifLoginTest {


    @Test
    public void gecersizPassword() {


        //1- https://www.testotomasyonu.com/ anasayfasina gidin

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();

        testOtomasyonPage.accountLinki.click();
        // 3- 3 farkli test method’u olusturun.
        // - gecerli username, gecersiz password

        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        testOtomasyonPage.loginButonu.click();

        // - gecersiz username, gecerli password
        // - gecersiz username, gecersiz password.
        //4- Login butonuna basarak login olun
        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());
        ReusableMethods.bekle(2);
        Driver.quitDriver();


    }

    @Test
    public void gecersizEmailTest() {


        //1- https://www.testotomasyonu.com/ anasayfasina gidin

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();

        testOtomasyonPage.accountLinki.click();
        // 3- 3 farkli test method’u olusturun.
        // - gecerli username, gecersiz password

        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        testOtomasyonPage.loginButonu.click();

        // - gecersiz username, gecerli password
        // - gecersiz username, gecersiz password.
        //4- Login butonuna basarak login olun
        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());
        ReusableMethods.bekle(2);
        Driver.quitDriver();


    }
    @Test
    public void gecersizEmailGecersizSifre(){



            //1- https://www.testotomasyonu.com/ anasayfasina gidin

            Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

            //2- account linkine basin

            TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();

            testOtomasyonPage.accountLinki.click();
            // 3- 3 farkli test method’u olusturun.
            // - gecerli username, gecersiz password

            testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
            testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

            testOtomasyonPage.loginButonu.click();

            // - gecersiz username, gecerli password
            // - gecersiz username, gecersiz password.
            //4- Login butonuna basarak login olun
            //5- Basarili olarak giris yapilamadigini test edin

            Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());
            ReusableMethods.bekle(2);
            Driver.quitDriver();



    }
}
