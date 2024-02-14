package tests.testNG_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_UrunSepetTest {
    @Test
    public void urunSepetiTest() {
        //1- https://www.testotomasyonu.com/ anasayfasina gidin

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- phone icin arama yapin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // 3- Listelenen sonuclardan ilkini tiklayin

        List<WebElement> urunler = testOtomasyonPage.bulunanUrunElementleriList;
        //4- urun ismini kaydedin ve sepete ekleyin

        urunler.get(0).click();
        String urun1 = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText();

        //5- your cart linkine tiklayin

        testOtomasyonPage.addToCartButonu.click();


        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin



        testOtomasyonPage.yourCardButonu.click();




        //7- sayfayi kapatin

        ReusableMethods.bekle(2);
        Driver.quitDriver();


    }


}
