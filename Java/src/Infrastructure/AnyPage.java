package Infrastructure;

import Infrastructure.TestNG.AnyTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AnyPage extends AnyTest {



    public void navigateToUrl(String url) {
        try {
            driver.get(url);
            System.out.println("Browsed to: " + url);
        } catch (Exception e) {
            System.out.println("Unable to browse to: " + url);
        }
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }


    public WebElement findElement(String[] element) {
        WebElement element1 = null;
        try {
            element1 = driver.findElement(By.cssSelector(element[0]));
            element1.isDisplayed();
            System.out.println("Element " + element[1] + " was found");
        } catch (Exception e) {
            System.out.println("Element " + element[1] + " was not found!");
        }
        return element1;
    }





    public void findScrollClickElement(String[] element) {
        WebElement element1 = findElement(element);
        scrollIntoView(element1, element[1]);
        click(element1, element[1]);
    }


    public void scrollIntoView(WebElement element, String webElementName) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
        }
    }

    protected void click(WebElement element, String webElementName) {
        try {
            element.click();
            System.out.println("Click on: " + webElementName);
        } catch (Exception e) {
            System.out.println("Can't click on: " + webElementName);
        }
    }

    public void waitForPageToLoad() {
        try {
            new WebDriverWait(driver, 15).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
        }
    }

    public void waitForVisibilityOfElement(String[] element) {
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(findElement(element)));
            System.out.println(element[1] + " is visible on the page");
        } catch (Exception e) {
            System.out.println(element[1] + " is not visible on the page!");
        }
    }

    }



