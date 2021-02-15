package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

        private WebDriver driver;

        @FindBy(id="id_content")
       private WebElement content;

        @FindBy(name = "syntax")
        private WebElement syntaxHighlight;

        @FindBy(name = "expiration")
        private WebElement expiration;

        @FindBy(id = "id_poster")
        private WebElement postersName;

        @FindBy(xpath = "//input[@value='Paste!']")
        private WebElement pasteButton;

        private static String PAGE_URL="https://paste.ubuntu.com";

        //Constructor
        public HomePage(WebDriver driver) {
            this.driver = driver;
            //Initialise Elements
            PageFactory.initElements(driver, this);
        }

        public void open() {
            driver.get(PAGE_URL);
           // new WebDriverWait(driver,10)
             //       .until(CustomConditions.jQ);
             //       return this;
            PageFactory.initElements(driver, this);
           // return this;
        }

        public void setContent(String inputText){
            content.sendKeys(inputText);
            content.sendKeys(Keys.RETURN);
        }

        public void setSyntax(){
            Select SyntaxHighlight = new Select(driver.findElement(By.name("syntax")));
            SyntaxHighlight.selectByVisibleText("Bash");
        }

        public void  setExpiration(){
            Select ExpValue = new Select(driver.findElement(By.name("expiration")));
            ExpValue.selectByVisibleText("A week");
        }

        public void setPosersName (String inputPostersName){
            postersName.clear();
            postersName.sendKeys(inputPostersName);
        }

        public void clickOnPaste() {
            pasteButton.click();
        }

}
