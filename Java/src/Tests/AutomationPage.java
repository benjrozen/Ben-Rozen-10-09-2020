package Tests;

import Infrastructure.AnyPage;
import org.junit.Test;
import org.openqa.selenium.*;

public class AutomationPage extends AnyPage {

    private static final String[] header = {"#gatsby-focus-wrapper > div > header", "Header image"};
    private static final String[] logo = {"#logom", "Logo"};
    private static final String[] intro = {"[class*='introduction__Introduction']", "Introduction text"};

    private static final String[] whatsappBtn = {"[class*='BtnWhatsapp']", "WhatsApp button"};

    private static final String[] howCanAssist = {"[class*='services'] h2[class*='typography']", "How can we assist header"};
    private static final String[] serviceCards = {"[class*='serviceCard__Card-sc']", "Service cards"};

    private static final String[] portfolio = {"[class*='portfolio__Portfolio-sc']", "Portfolio slider"};
    private static final String[] portfolioSliderNextBtn = {"[class*='slick-next']", "Slider next button"};
    private static final String[] firstSlidePortfolio = {"#gatsby-focus-wrapper > div > section.portfolio__Portfolio-sc-1bteqw2-0.iuKKXh > div > div.slick-list > div > div:nth-child(2)", "First slide portfolio"};
    private static final String[] secondSlidePortfolio = {"#gatsby-focus-wrapper > div > section.portfolio__Portfolio-sc-1bteqw2-0.iuKKXh > div > div.slick-list > div > div:nth-child(3)", "Second slide portfolio"};
    private static final String[] thirdSlidePortfolio = {"#gatsby-focus-wrapper > div > section.portfolio__Portfolio-sc-1bteqw2-0.iuKKXh > div > div.slick-list > div > div:nth-child(4)", "Third slide portfolio"};
    private static final String[] fourthSlidePortfolio = {"#gatsby-focus-wrapper > div > section.portfolio__Portfolio-sc-1bteqw2-0.iuKKXh > div > div.slick-list > div > div:nth-child(5)", "Fourth slide portfolio"};
    private static final String[] fifthSlidePortfolio = {"#gatsby-focus-wrapper > div > section.portfolio__Portfolio-sc-1bteqw2-0.iuKKXh > div > div.slick-list > div > div:nth-child(6)", "Fifth slide portfolio"};

    private static final String[] clients = {"[class*='customers__Container-sc']", "Clients slider"};
    private static final String[] firstSlideClients = {"#gatsby-focus-wrapper > div > section.customers__Customers-sc-1w1u0ay-0.eDDkCa > div.customers__Container-sc-1w1u0ay-2.gfsorQ > div > div > div > div:nth-child(5)", "First slide clients"};
    private static final String[] secondSlideClients = {"#gatsby-focus-wrapper > div > section.customers__Customers-sc-1w1u0ay-0.eDDkCa > div.customers__Container-sc-1w1u0ay-2.gfsorQ > div > div > div > div:nth-child(6)", "Second slide clients"};
    private static final String[] thirdSlideClients = {"#gatsby-focus-wrapper > div > section.customers__Customers-sc-1w1u0ay-0.eDDkCa > div.customers__Container-sc-1w1u0ay-2.gfsorQ > div > div > div > div:nth-child(7)", "Third slide clients"};
    private static final String[] fourthSlideClients = {"#gatsby-focus-wrapper > div > section.customers__Customers-sc-1w1u0ay-0.eDDkCa > div.customers__Container-sc-1w1u0ay-2.gfsorQ > div > div > div > div:nth-child(8)", "Fourth slide clients"};

    private static final String[] qna = {"[class*='questions__Questions']", "Q&A section"};
    private static final String[] qnaCards = {"[class*='questionCard__QuestionCard-sc-1silg10-0 bqSxgS']", "Q&A section cards"};

    private static final String[] contactUs = {"#section-contact", "Contact us section"};
    private static final String[] contactUsFormName = {"#name", "Contact us form company field"};
    private static final String[] contactUsFormCompany = {"#company", "Contact us form company field"};
    private static final String[] contactUsFormEmail = {"#email", "Contact us form e-mail field"};
    private static final String[] contactUsFormPhone = {"#telephone", "Contact us form telephone field"};
    private static final String[] submitContactFormBtn = {"[type='button']", "Contact form submit button"};
    private static final String[] thankYou = {"[class*='thankYou__container']", "Thank you text"};

    private static final String[] contactPerson = {"[class*='contactPerson__ContactPerson']", "Contact person section"};

    private static final String[] linkedinSocBtn = {"[href*='https://www.linkedin.com']", "LinkedIn social media button"};
    private static final String[] whatsappinSocBtn = {"[href*='https://api.whatsapp.com']", "WhatsApp social media button"};
    private static final String[] fbSocBtn = {"[href*='https://www.facebook.com/']", "Facebook social media button"};
    private static final String[] oloSocBtn = {"[href*='https://herolo.co.il']", "Olo social media button"};

    private static final String[] backToTop = {"[class*='backToTop__BtnGoUp']", "Back to top button"};

    private static final String[] helpFormName = {"[name='name']", "Help form name field"};
    private static final String[] helpFormEmail = {"[name='email']", "Help form e-mail field"};
    private static final String[] helpFormPhone = {"[name='phone']", "Help form telephone field"};
    private static final String[] submitHelpFormBtn = {"[class*='Footer__Button-sc']", "Help form submit button"};


    @Test
    public void autoPage() throws Exception {
        navigateToUrl("http://automation.herolo.co.il/");
        driver.manage().window().maximize();
        waitForVisibilityOfElement(header);
        findElement(logo);
        findElement(intro);

        clickOn(whatsappBtn);
        switchToCurrentTab();
        checkURLRedirect("https://api.whatsapp", "WhatsApp button");
        returnToInitialTab();

        findElement(howCanAssist);
        findElement(serviceCards);

        scrollToElement(portfolio);
        findElement(firstSlidePortfolio);
        clickOn(portfolioSliderNextBtn);
        findElement(secondSlidePortfolio);
        clickOn(portfolioSliderNextBtn);
        findElement(thirdSlidePortfolio);
        clickOn(portfolioSliderNextBtn);
        findElement(fourthSlidePortfolio);
        clickOn(portfolioSliderNextBtn);
        findElement(fifthSlidePortfolio);

        scrollToElement(clients);
        findElement(firstSlideClients);
        findElement(secondSlideClients);
        findElement(thirdSlideClients);
        findElement(fourthSlideClients);

        scrollToElement(qna);
        findElements(qnaCards);

        scrollToElement(contactUs);
        typeIn(contactUsFormName, "Mark Crisp");
        typeIn(contactUsFormCompany, "Hummus Tanami");
        typeIn(contactUsFormEmail, "m@c.com");
        typeIn(contactUsFormPhone, "0541234567");
        findElement(submitContactFormBtn).click();
        waitForUrlToBe("https://automation.herolo.co.il/thank-you/");
        findElement(thankYou);
        checkURLRedirect("thank-you", "ContactUs form submission");

        driver.navigate().back();
        scrollToElement(contactPerson);

        clickOn(linkedinSocBtn);
        switchToCurrentTab();
        checkURLRedirect("https://www.linkedin.com/", "LinkedIn button");
        returnToInitialTab();
        waitForPageToLoad();

        clickOn(whatsappinSocBtn);
        switchToCurrentTab();
        checkURLRedirect("https://api.whatsapp", "WhatsApp button");
        returnToInitialTab();
        waitForPageToLoad();

        clickOn(fbSocBtn);
        switchToCurrentTab();
        checkURLRedirect("https://www.facebook.com/Herolofrontend", "Facebook button");
        returnToInitialTab();
        waitForPageToLoad();

        clickOn(oloSocBtn);
        switchToCurrentTab();
        checkURLRedirect("olo.co.il", "Olo button");
        returnToInitialTab();
        waitForPageToLoad();

        clickOn(backToTop);

        waitForVisibilityOfElement(helpFormName);
        typeIn(helpFormName, "Mark Crisp");
        typeIn(helpFormEmail, "m@c.com");
        typeIn(helpFormPhone, "0541234567");
        findElement(submitHelpFormBtn).click();
        checkURLRedirect("https://automation", "Help form submission");
        driver.navigate().back();
    }
}
