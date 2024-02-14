package UI_Project;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.JobExplorerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_036 {

    SoftAssert softAssert = new SoftAssert();

    JobExplorerPage jobExplorerPage = new JobExplorerPage();

    //US_036	Admin olarak giriş yaptıktan sonra Money menüsü altındaki Transactions
    // menüsü ile işlemleri görüntüleyebilmeliyim, yapılan işlemlerin ayrıntılarını görüntüleyebilmeliyim


    @Test
    public void MoneyMenuTest(){

        Driver.getDriver().get(ConfigReader.getProperty("jobExAdminUrl"));

        //US_036	Admin olarak giriş yaptıktan sonra

        jobExplorerPage.AdminEmailKutusu.sendKeys(ConfigReader.getProperty("JobExAdminEmail"));
        jobExplorerPage.AdminParolaKutusu.sendKeys(ConfigReader.getProperty("JobExAdminParola"));

        jobExplorerPage.AdminGirisButonu.click();



        //Money menüsü altındaki Transactions
        // menüsü ile işlemleri görüntüleyebilmeliyim
        //yapılan işlemlerin ayrıntılarını görüntüleyebilmeliyim

        jobExplorerPage.MoneyMenuElementi.click();

        ReusableMethods.bekle(2);

        jobExplorerPage.MoneyMenuTransactionElementi.click();

        softAssert.assertTrue(jobExplorerPage.TransactionsListSatirlar.size()>0);



        softAssert.assertAll();










    }
}
