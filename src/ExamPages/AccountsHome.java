package ExamPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ruber Cuellar on 8/10/2015.
 */
public class AccountsHome {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @FindBy(name = "new")
    @CacheLookup
    private WebElement newBtn;

    public AccountsHome(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public NewAccount clickNewBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(newBtn));
        newBtn.click();
        return new NewAccount(driver);
    }
    public Account clickAccount(String name)
    {
        driver.findElement(By.linkText(name)).click();
        return new Account(driver);
    }






}
