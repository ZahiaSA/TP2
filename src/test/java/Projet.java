import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Projet {
    WebDriver driver;
    @BeforeMethod
    public void ouvrirChrome(){
        driver = new ChromeDriver();
        driver.get("https://www.ebay.fr/");
        driver.manage().window().maximize();

        /*driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        By cookiesID = By.id("gdpr-banner-accept");
        driver.findElement(cookiesID).click();*/

    }

    /*@AfterMethod
    public void fermerChrome() {
        driver.quit();
    }*/


    @Test
    public void testAmazon() {
        // Arrange


        // Act
        By exploirerParCategorieSelector = By.cssSelector("#gh-shop-a");
        driver.findElement(exploirerParCategorieSelector).click();

        By sportEtVacancesSelector = By.cssSelector("[_sp='m570.l3778']");
        driver.findElement(sportEtVacancesSelector).click();

        By AnnonceSelector = By.cssSelector(".b-list__items_nofooter li:nth-of-type(1)");
        driver.findElement(AnnonceSelector).click();

        By ajouterPanier = By.id("isCartBtn_btn");
        driver.findElement(ajouterPanier).click();

        // Asset
        By nomAttendu = By.cssSelector(".BOLD");

        String nomArticle = driver.findElement(nomAttendu).getText();


        By nomObtenu = By.cssSelector(".listsummary-content-itemdetails");
        String nomPanier = driver.findElement(nomObtenu).getText();

        Assert.assertTrue(nomPanier.contains(nomArticle),"on cherche le bon article");
    }

}
