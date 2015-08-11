package ExamPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ruber Cuellar on 8/10/2015.
 */
public class Account {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @FindBy(name = "delete")
    @CacheLookup
    private WebElement deleteBtn;

    public Account(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }
    public MainPage deleteBtn()
    {
        deleteBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.switchTo().defaultContent();
        return new MainPage(driver);
    }

}
