package auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class WePage {

    final static String TITLE = "WE.org | Making Doing Good, Doable | Join the WE Movement";
    final static String HEADING = "About WE\n" + 
    		"Our Work\n" + 
    		"Get Doing\n" + 
    		"DONATESHOPTRAVELTRACK YOUR IMPACT";
    WebDriver driver;
    String xpathHeading = "//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div[2]/nav";
    String xpathLink = "//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div[2]/nav/div[2]/a[1]";

    public WePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyWelcomePageTitle() {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, TITLE,
                "Actual title " + actualTitle + " should be same as expected " + TITLE);
    }

    public void verifyWelcomePageHeader() {
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void clickOnLinkViaLinkText(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    public void clickOnLinkViaPartialText(String link) {
        driver.findElement(By.partialLinkText(link)).click();
    }

    public Object clickOnLink(String link) {
    		driver.findElement(By.xpath(link)).click();
        return this;
    }
}
