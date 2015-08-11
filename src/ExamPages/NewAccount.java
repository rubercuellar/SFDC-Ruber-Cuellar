package ExamPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ruber Cuellar on 8/10/2015.
 */
public class NewAccount {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement oppName;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;


    public NewAccount(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public NewAccount setAccountName(String accountName){
        oppName.sendKeys(accountName);
        return this;
    }
    public MainPage clickSaveButton()
    {
        saveBtn.click();
        return new MainPage(driver);
    }

}
