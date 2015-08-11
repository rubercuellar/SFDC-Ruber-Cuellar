package ExamTests;

import ExamPages.*;
import ExamPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class CreateOpportunity {

    private MainPage mainPage;
    private Opportunity opportunity;
    private AccountsHome accountsHome;
    private NewAccount newAccount;
    private OpportunitiesName opportunitiesName;
    private NewOpportunity newOpportunity;

    private final String username = "rubercuellar2@new.com";
    private final String password = "Control123*";
    private final String newOpportunityName = "New Project5";
    private final String newAccountName = "RuberAccount5";
    private final String closeDate = "8/8/2015";
    private final String stage = "Prospecting";

    @BeforeClass
    public void setUp() {
        ExamPages.LoginPage loginPage = new LoginPage()
                .setUsernameTxt(username)
                .setPasswordTxt(password);
        mainPage = loginPage.clickLoginBtn();
        accountsHome = mainPage.clickAccountsLabel();
        newAccount = accountsHome.clickNewBtn();
        newAccount.setAccountName(newAccountName);
        newAccount.clickSaveButton();

    }
    @Test
    public void testUntitled() {

        opportunitiesName = mainPage.clickOpportunitiesLabel();
        newOpportunity = opportunitiesName.clickNewOpportunity()
                .setOppName(newOpportunityName)
                .setDate(closeDate)
                .setStage(stage)
                .setAccountName(newAccountName);

        opportunity = newOpportunity.clickSaveButton();
        Assert.assertEquals(newOpportunityName, opportunity.getName());
        Assert.assertEquals(newAccountName, opportunity.getAccount());
        Assert.assertEquals(closeDate, opportunity.getCloseDate());
        Assert.assertEquals(stage, opportunity.getStage());

    }

    @AfterClass
    public void tearDown() {

        mainPage = opportunity.clickDeleteBtn();
        accountsHome = mainPage.clickAccountsLabel();
        Account account = accountsHome.clickAccount(newAccountName);
        mainPage = account.deleteBtn();
    }
}
