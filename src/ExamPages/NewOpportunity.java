package ExamPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Ruber Cuellar on 8/10/2015.
 */
public class NewOpportunity {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @FindBy(id = "opp3")
    @CacheLookup
    private WebElement oppName;

    @FindBy(id = "opp4")
    @CacheLookup
    private WebElement accountName;

    @FindBy(xpath = "//img[contains(@alt,'Account Name Lookup (New Window)')]")
    @CacheLookup
    private WebElement lookUp;

    @FindBy(id = "opp9")
    @CacheLookup
    private WebElement closeDate;

    @FindBy(id = "opp11")
    @CacheLookup
    private WebElement stageComboBox;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;

    public NewOpportunity(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public NewOpportunity setOppName(String opportunityName)
    {
        oppName.sendKeys(opportunityName);
        return this;
    }

    public NewOpportunity setDate(String date)
    {
        closeDate.sendKeys(date);
        return this;
    }

    public NewOpportunity setStage(String stage)
    {
        Select select = new Select(stageComboBox);
        select.selectByVisibleText(stage);
        return this;
    }

    public NewOpportunity setAccountName(String accountName)
    {
        wait.until(ExpectedConditions
                .elementToBeClickable(lookUp));
        lookUp.click();
        Set<String> setWindows = driver.getWindowHandles();
        LinkedList<String> listWindows = new LinkedList<>(setWindows);
        driver.switchTo().window(listWindows.getLast());
        new Lookup(driver, accountName);
        return this;
    }
    public Opportunity clickSaveButton()
    {
        saveBtn.click();
        return new Opportunity(driver);
    }

}
