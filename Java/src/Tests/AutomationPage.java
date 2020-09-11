package Tests;


import Infrastructure.AnyPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutomationPage extends AnyPage{

    private static final String[] header = {"#gatsby-focus-wrapper > div > header", "Header image"};
    private static final String[] logo = {"#logom", "Logo"};
    private static final String[] intro = {"[class*='introduction__Introduction']", "Introduction text"};
    private static final String[] whatsappBtn = {"[class*='BtnWhatsapp']", "WhatsApp button"};
    private static final String[] howCanAssist = {"[class*='services'] h2[class*='typography']", "How can we assist header"};
    private static final String[] serviceCards = {"[class*='serviceCard__Card-sc']", "Service cards"};





    @Test
    public void autoPage() throws InterruptedException {


        navigateToUrl("http://automation.herolo.co.il/");
       /* driver.get("http://automation.herolo.co.il/");
        driver.manage().window().maximize();
*/
        waitForVisibilityOfElement(header);
        findElement(logo);
        findElement(intro);

        findScrollClickElement(whatsappBtn);
        if (getURL().contains("api.whatsapp")) {
            System.out.println("WhatsApp button redirect working");
        } else {
            System.out.println("No redirect after clicking WhatsApp button");
        }

        findElement(howCanAssist);
        findElement(serviceCards);









/*        WebElement e = driver.findElement(By.cssSelector("[class*='BtnWhatsapp']"));



        if (driver.getCurrentUrl().contains("whatsapp")) {
            System.out.println("well done");
        } else {
            System.out.println("whatsapp button not working");
        }*/


    }


}
