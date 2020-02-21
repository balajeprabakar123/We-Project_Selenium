package auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

import java.util.List;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */
public class DemoPage {

    final static String TITLE = "Donate Now";
    final static String HEADING = "GIVE ONE TIME";
    final static String HEADING2 = "GIVE MONTHLY";
    final static String Amount1 = "$75";
    final static String Amount2 = "$125";
    final static String Amount3 = "$250";


    WebDriver driver;

    public DemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyDemoPageTitle() {
        String actualTitle = driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[3]/div[1]/div/div[1]/div/div/div[1]/h5")).getText();
        assertEquals(actualTitle, TITLE,
                "Actual title " + actualTitle + " should be same as expected " + TITLE);
    }
    
    public void verifyDemoPageAmount() {
        String actualAmount = driver.findElement(By.xpath("//*[@id=\"give-one-time\"]/div/form/div[1]/div[1]/span")).getText();
        assertEquals(actualAmount, Amount1,
                "Actual Amount " + actualAmount + " should be same as expected " + Amount1);
        String actualAmount2 = driver.findElement(By.xpath("//*[@id=\"give-one-time\"]/div/form/div[1]/div[2]/span")).getText();
        assertEquals(actualAmount2, Amount2,
                "Actual Amount " + actualAmount2 + " should be same as expected " + Amount2);
        String actualAmount3 = driver.findElement(By.xpath("//*[@id=\"give-one-time\"]/div/form/div[1]/div[3]/span")).getText();
        assertEquals(actualAmount3, Amount3,
                "Actual Amount " + actualAmount3 + " should be same as expected " + Amount3);
    }
    

    public void selectCurrency(String Currency) {
    	driver.findElement(By.xpath("//div[3]/div[1]/div/div[1]//div[2]//div[1]/div/form/div[2]/label/div/div[1]/li")).click();
    	//driver.findElement(By.xpath("//*[@id=\"currency-dropdown-control\"]")).click();
    	List<WebElement>ListOfCurrency= driver.findElements(By.xpath("//*[@id=\"give-one-time\"]/div/form/div[2]/label/div/div[2]/ul"));
        for (WebElement opt : ListOfCurrency) {
            if (Currency.equalsIgnoreCase("cad")) {            	
            	opt.click();
                return;
            }
            else if (Currency.equalsIgnoreCase("usd")) {            	
            	opt.click();
                return;
            }
        }
    }

    public void verifyDemoPageHeader() {
        WebElement headerEle = driver.findElement(By.xpath("//*[@id=\"tab-give-one-time\"]"));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
        WebElement headerEle2 = driver.findElement(By.xpath("//*[@id=\"tab-give-monthly\"]"));
        String actualHeading2 = headerEle2.getText();
        assertEquals(actualHeading2, HEADING2,
                "Actual heading '" + actualHeading2 + "' should be same as expected '" + HEADING2 + "'.");
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

	public void donate() {
        driver.findElement(By.xpath("//*[@id=\"give-one-time\"]/div/form/div[5]/button")).click();

		
	}
}
