package UI_Project;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.JobExplorerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_025 {

    SoftAssert softAssert = new SoftAssert();

    JobExplorerPage jobExplorerPage = new JobExplorerPage();

    //US_025	Admin olarak giriş yaptıktan sonra Jobs
    // menüsü altındaki Categories menüsünden sitede yer alan kategorileri görüntüleyebilmeli,
    // yeni kategori ekleyebilmeli, eklediğim kategoriyi görüntüleyebilmeli, düzenleyebilmeli ve silebilmeliyim


    @Test
    public void AdminTest() {

        //US_025	Admin olarak giriş yaptıktan sonra

        Driver.getDriver().get(ConfigReader.getProperty("jobExAdminUrl"));

        jobExplorerPage.AdminEmailKutusu.sendKeys(ConfigReader.getProperty("JobExAdminEmail"));
        jobExplorerPage.AdminParolaKutusu.sendKeys(ConfigReader.getProperty("JobExAdminParola"));

        jobExplorerPage.AdminGirisButonu.click();


        //Jobs menüsü altındaki Categories menüsünden sitede yer alan kategorileri görüntüleyebilmeli,

        jobExplorerPage.JobsMenuElementi.click();
        jobExplorerPage.CategoriesElementi.click();

        softAssert.assertTrue(jobExplorerPage.CategoriesTableElementi.isDisplayed());


        // yeni kategori ekleyebilmeli, , düzenleyebilmeli ve silebilmeliyim

        jobExplorerPage.CategoriesAddNewElementi.click();

        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());

        String createJobTitle = faker.job().position();

        jobExplorerPage.CategoriesAddNewNameElementi.click();

        actions.sendKeys(createJobTitle).sendKeys(Keys.TAB)
                .sendKeys(faker.job().keySkills()).sendKeys(Keys.TAB)
                .sendKeys(faker.job().field()).perform();

        jobExplorerPage.CategoriesAddNewSaveElementi.click();

        // eklediğim kategoriyi görüntüleyebilmeli

        List<String> JobNames = ReusableMethods.stringListeCevir(jobExplorerPage.CategoriesJobIsimleriElementi);

        softAssert.assertTrue(JobNames.contains(createJobTitle));

        // düzenleyebilmeli

        jobExplorerPage.JobCategoriesIlkIsEditButonu.click();

        String expectedSayfaTitle = "Edit Category";
        String actualSayfaTitle = jobExplorerPage.CategoriesEditYaziElementi.getText();

        softAssert.assertEquals(actualSayfaTitle, expectedSayfaTitle);


        // ve silebilmeliyim

        Driver.getDriver().navigate().back();

        jobExplorerPage.JobCategoriesIlkIsDeleteButonu.click();

        ReusableMethods.bekle(1);

        jobExplorerPage.JobCategoriesIlkIsDeleteOnayButonu.click();

        ReusableMethods.bekle(1);

        softAssert.assertTrue(jobExplorerPage.JobCategoriesDeleteOnayYazisi.isDisplayed());




        softAssert.assertAll();

        Driver.quitDriver();


    }
}
