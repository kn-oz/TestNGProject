package tests.testNG_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class practiseSorusu extends TestBase {

    @Test
    public void aramaTest() {

        //1- https://www.testotomasyonu.com/ sayfasına gidin.
        driver.get("https://www.testotomasyonu.com/");
        // 2- Arama kutusuna “dress” yazip aratin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress" + Keys.ENTER);

        // 3- Görüntülenen sonuçların sayısını yazdırın

        List<WebElement> bulunanUrunlerElementi = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        System.out.println("Bulunan ürün sayısı : " + bulunanUrunlerElementi.size());

        // 4- Listeden ilk urunun resmine tıklayın.

        bulunanUrunlerElementi.get(0).click();

        ReusableMethods.bekle(2);

        //5- Urun detayinda dress kelimesi geçtiğini test edin.

        WebElement urunSayfasiIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedIcerik = "dress";
        String actualIcerik = urunSayfasiIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));


    }

}
