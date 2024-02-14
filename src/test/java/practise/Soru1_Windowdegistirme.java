package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class Soru1_Windowdegistirme extends TestBase {

    @Test
    public void windowtest() {

        //https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.

        String expectedText = "Add/Remove Elements";
        WebElement textelementi = driver.findElement(By.tagName("h2"));
        String actualText = textelementi.getText();
        Assert.assertEquals(actualText, expectedText);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        //● ’Please click for Electronics Products’ linkine tiklayin.

        String ilkSayfaWhd = driver.getWindowHandle();

        WebElement electronicsLinkiElement = driver.findElement(By.xpath("//a[text()='Electronics Products']"));
        electronicsLinkiElement.click();
        ReusableMethods.bekle(3);

        //● Electronics sayfasinin acildigini test edin

        Set<String> windowHandleDegerleri = driver.getWindowHandles();

        String ikinciSayfaWhd = "";

        for (String each : windowHandleDegerleri) {

            if (!(each.equals(windowHandleDegerleri))) {

                ikinciSayfaWhd = each;
            }


        }

        driver.switchTo().window(ikinciSayfaWhd);

        expectedTitle = "Test Otomasyonu - Electronics";
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        //● Bulunan urun sayisinin 16 olduğunu test edin

        WebElement BulunanUrunyaziElementi = driver.findElement(By.xpath("//*[@class='product-count-text']"));

        String expectedUrunSayisi = "16";
        String actualUrunSayisi = BulunanUrunyaziElementi.getText();

        Assert.assertTrue(actualUrunSayisi.contains(expectedUrunSayisi));

        //● Ilk actiginiz addremove sayfasina donun

        driver.switchTo().window(ilkSayfaWhd);
        ReusableMethods.bekle(2);

        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));




    }
}
