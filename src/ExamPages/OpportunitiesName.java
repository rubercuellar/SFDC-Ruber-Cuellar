package ExamPages;

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
public class OpportunitiesName {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @FindBy(name = "new")
    @CacheLookup
    private WebElement newBtn;

    public OpportunitiesName(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
}

    public NewOpportunity clickNewOpportunity(){
        wait.until(ExpectedConditions.elementToBeClickable(newBtn));
        newBtn.click();
        return new NewOpportunity(driver);

    }




}
