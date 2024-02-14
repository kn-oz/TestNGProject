package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class Soru2_WindowDegistirme extends TestBase {

    @Test
    public void windowdegistirme(){

        //Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        WebElement sayfadakiText= driver.findElement(By.tagName("h3"));

        String expectedText = "Opening a new window";
        String actualText = sayfadakiText.getText();

        Assert.assertEquals(expectedText,actualText);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //● Click Here butonuna basın.
        String ilkSayfaWhd = driver.getWindowHandle();
        System.out.println(ilkSayfaWhd);

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();



        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.

        Set<String> windowhandles = driver.getWindowHandles();
        System.out.println(windowhandles);
        String ikinciWhd = "";

        for (String eacwhd : windowhandles){
            driver.switchTo().window(eacwhd);
            String oldugumuzWhd = driver.getWindowHandle();
            if (!(oldugumuzWhd.equals(ilkSayfaWhd))){
                eacwhd = ikinciWhd;
            }
        }


        ReusableMethods.bekle(2);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        expectedText = "New Window";
        actualText = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(actualText,expectedText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaWhd);
        ReusableMethods.bekle(2);

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);





    }
}
