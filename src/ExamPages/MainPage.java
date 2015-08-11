package ExamPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ruber Cuellar on 8/7/2015.
 */
public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @FindBy(id = "userNavLabel")
    @CacheLookup
    private WebElement userLabel;

    @FindBy(linkText = "Opportunities")
    @CacheLookup
    private WebElement opportunitiesLabel;

    @FindBy(linkText = "Accounts")
    @CacheLookup
    private WebElement accountsLabel;

    @FindBy(xpath = "//a[contains(.,'Logout')]")
    @CacheLookup
    private WebElement logOut;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void clickUserLabel()
    {
        userLabel.click();
        logOut.click();

    }
    public AccountsHome clickAccountsLabel()
    {
        wait.until(ExpectedConditions.elementToBeClickable(accountsLabel));
        accountsLabel.click();
        return new AccountsHome(driver);

    }
    public OpportunitiesName clickOpportunitiesLabel()
    {
        wait.until(ExpectedConditions.elementToBeClickable(opportunitiesLabel));
        opportunitiesLabel.click();
        return new OpportunitiesName(driver);
    }








}
