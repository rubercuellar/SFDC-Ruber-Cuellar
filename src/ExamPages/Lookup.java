package ExamPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Ruber Cuellar on 8/11/2015.
 */
public class Lookup {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @FindBy(id = "lksrch")
    @CacheLookup
    private WebElement searchTxt;

    @FindBy(name = "go")
    @CacheLookup
    private WebElement goBtn;

    public Lookup (WebDriver driver, String account) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);

        PageFactory.initElements(driver, this);
        setSearchTxt(account);
        clickGoBtn();
        clickAccount(account);
    }

    public Lookup setSearchTxt(String account)
    {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("searchFrame")));
        wait.until(ExpectedConditions.visibilityOf(searchTxt));
        searchTxt.sendKeys(account);
        return this;
    }
    public Lookup clickGoBtn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(goBtn));
        goBtn.click();
        return this;
    }
    public Lookup clickAccount(String account)
    {
        Set<String> setWindows = driver.getWindowHandles();
        LinkedList<String> listWindows = new LinkedList<>(setWindows);
        driver.switchTo().window(listWindows.getLast());
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("resultsFrame")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(account))));
        driver.findElement(By.linkText(account)).click();
        driver.switchTo().window(listWindows.getFirst());
        return this;
    }
}
