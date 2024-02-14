package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class JobExplorerPage {

    public JobExplorerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement AdminEmailKutusu;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement AdminParolaKutusu;

    @FindBy(xpath = "//button[@class='btn btn-block login-button']")
    public WebElement AdminGirisButonu;

    @FindBy(xpath = "//span[@class='icon voyager-archive']")
    public WebElement JobsMenuElementi;

    @FindBy(xpath = "//span[text()='Categories']")
    public WebElement CategoriesElementi;

    @FindBy(xpath = "//table[@class='table table-hover']")
    public WebElement CategoriesTableElementi;

    @FindBy(xpath = "//*[@class='btn btn-success btn-add-new']")
    public WebElement CategoriesAddNewElementi;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement CategoriesAddNewNameElementi;

    @FindBy(xpath = "//button[@class='btn btn-primary save']")
    public WebElement CategoriesAddNewSaveElementi;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> CategoriesJobIsimleriElementi;

    @FindBy(xpath = "(//*[@class='btn btn-sm btn-primary pull-right edit'])[1]")
    public WebElement JobCategoriesIlkIsEditButonu;

    @FindBy(xpath = "//h1[@class='page-title']")
    public WebElement CategoriesEditYaziElementi;

    @FindBy(xpath = "(//a[@class='btn btn-sm btn-danger pull-right delete'])[1]")
    public WebElement JobCategoriesIlkIsDeleteButonu;

    @FindBy(xpath = "//input[@value='Yes, Delete it!']")
    public WebElement JobCategoriesIlkIsDeleteOnayButonu;

    @FindBy(xpath = "//div[text()='Successfully Deleted Category']")
    public WebElement JobCategoriesDeleteOnayYazisi;

    @FindBy(xpath = "//a[@href='#27-dropdown-element']")
    public WebElement MoneyMenuElementi;


    @FindBy(xpath = "//*[text()='Transactions']")
    public WebElement MoneyMenuTransactionElementi;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> TransactionsListSatirlar;


}
