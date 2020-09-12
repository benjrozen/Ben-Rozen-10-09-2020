package Infrastructure;

import Infrastructure.TestNG.AnyTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;


public class AnyPage extends AnyTest {

    public ArrayList<String> openTabs;


    public void navigateToUrl(String url) {
        try {
            driver.get(url);
            System.out.println("Browsed to: " + url);
        } catch (Exception e) {
            System.out.println("Unable to browse to: " + url);
        }
    }

    public String getURL() {
        String theURL = driver.getCurrentUrl();
        return driver.getCurrentUrl();
    }

    public void waitForUrlToBe(String url) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe(url));
            System.out.println("Url now contains: " + url);
        } catch (Exception e) {
            System.out.println("Url does notcontain: " + url);
        }
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

    public List<WebElement> findElements(String[] element) {
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(By.cssSelector(element[0]));
            System.out.println("Found total of " + elements.size() + " elements of type: " + element[1]);
        } catch (Exception e) {
            System.out.println("Could not find list of elements: " + element[1]);
        }
        return elements;
    }

    public void scrollToElement(String[] element) {
        WebElement element1 = findElement(element);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", element1);
        } catch (Exception e) {
        }
    }

    public void clickOn(String[] element) {
        try {
            findElement(element).click();
            System.out.println("Clicked on: " + element[1]);
        } catch (Exception e) {
            System.out.println("Can't click on: " + element[1]);
        }
    }

    public void checkURLRedirect(String url, String section) {
        if (getURL().contains(url)) {
            System.out.println(section + " redirect working");
        }else {
            System.out.println("No redirect after clicking: " + section);
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

    public void typeIn(String[] element, String text) {
        WebElement element1 = findElement(element);
        clear(element1);
        element1.sendKeys(text);
    }

    public void clear(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
        }
    }

    public void switchToCurrentTab(){
        openTabs =    new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(openTabs.get(1));
    }

    public void returnToInitialTab(){
        driver.close();
        driver.switchTo().window(openTabs.get(0));
    }
}



