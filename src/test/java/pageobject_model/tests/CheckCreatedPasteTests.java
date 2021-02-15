package pageobject_model.tests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


public class CheckCreatedPasteTests {

    private WebDriver driver;
    private HomePage createdPage;
  //  private NewPaste newpaste;
    public static String newPageUrl;


    @BeforeMethod(alwaysRun = true)

    public void browserSetup() {
      driver = new ChromeDriver();
      createdPage = new HomePage(driver);
     // newpaste = new NewPaste(driver);
     }

    @Test (description = "Paste is created")

   public void CheckCreatedPaste() {

        createdPage.open();

        createdPage.setContent("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        createdPage.setExpiration();
        createdPage.setSyntax();

        createdPage.setPosersName("how to gain dominance among developers");
        createdPage.clickOnPaste();

        newPageUrl = driver.getCurrentUrl();
        System.out.println(newPageUrl);

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
   }


    @Test (description = "Page title is match to Poster's name")

       public void PageTitleIsNotMatchesPostersName() {

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        System.out.println(newPageUrl);
        driver.get(newPageUrl);
        String title = driver.getTitle();
        Assert.assertNotEquals("how to gain dominance among developer", title);

    }

    @Test (description = "Content is matches")

   public void ContentIsMathes() {
        driver.get(newPageUrl);
        String content = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";

        String result = driver.findElement(By.xpath("//td[@class='code']/div")).getText();
        Assert.assertEquals(content, result);
        System.out.println(result);
        System.out.println(content);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }


   @Test (description = "Syntax is Highlight ")

    public void SyntaxIsHighlight() {
        driver.get(newPageUrl);
        String color1 = driver.findElement(By.xpath("//td[@class='code']/div")).getCssValue("color");
        String color2 = driver.findElement(By.xpath("//*[@class='s2']")).getCssValue("color");

       System.out.println(color1);
       System.out.println(color2);

       Assert.assertNotEquals(color1,color2);
    }

   @AfterMethod(alwaysRun = true)
    public void browserTearDown () {
       getDriver().quit();
       setDriver(null);
    }

    public WebDriver getDriver() {
       return driver;
    }

  public void setDriver(WebDriver driver) {
   this.driver = driver;
   }
}

