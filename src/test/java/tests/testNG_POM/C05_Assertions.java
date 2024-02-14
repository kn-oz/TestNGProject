package tests.testNG_POM;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.text.html.parser.Entity;

public class C05_Assertions {

    @Test
    public void aramaTest(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        int expectedMinUrunSayisi = 3;
        int actualUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualUrunSayisi>expectedMinUrunSayisi);

        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

        String expectedIsımIcerik = "phone";
        String actualUrunIsmi = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsımIcerik));
        ReusableMethods.bekle(3);
        Driver.quitDriver();


    }
}
