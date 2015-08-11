package ExamPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ruber Cuellar on 8/10/2015.
 */
public class Opportunity {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @FindBy(name = "del")
    @CacheLookup
    private WebElement deleteBtn;

    public Opportunity(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public String getName() {

        return driver.findElement(By.xpath("//div[@id='opp3_ileinner']")).getText();

    }
    public String getAccount() {

        return driver.findElement(By.xpath("//td[@id='opp4_ilecell']")).getText();

    }
    public String getCloseDate() {

        return driver.findElement(By.xpath("//div[contains(@id,'opp9_ileinner')]")).getText();

    }
    public String getStage() {

        return driver.findElement(By.xpath("//div[contains(@id,'opp11_ileinner')]")).getText();

    }

    public MainPage clickDeleteBtn()
    {
        deleteBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.switchTo().defaultContent();
        return new MainPage(driver);
    }



}
