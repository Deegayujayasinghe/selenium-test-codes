import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    //01 take me to dashboard

    WebDriver driver;

    @BeforeMethod
    public void openLinkTests(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }


    @Test
    public void LinkTest(){
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();



       // 02 find by destination

        WebElement wheretoGo =driver.findElement(By.partialLinkText("Find the URL without clicking me."));
        String path = wheretoGo.getAttribute("href");
        System.out.println("This link is going to : " + path);



        //03 Am i broken link?

        WebElement brokenLink = driver.findElement(By.partialLinkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")) {
            System.out.println("The link is broken");
        }else {
            System.out.println("Not broken");
        }
        driver.navigate().back();



        // 04 duplicate link

        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();



        // 05 count page links

        List<WebElement> countfullpageLinks =  driver.findElements(By.tagName("a"));
        int pageLinkCount = countfullpageLinks.size();
        System.out.println("Count of full page links : " + pageLinkCount);



        // 06 count layout links

        WebElement layoutElemnt = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLinks = layoutElemnt.findElements(By.tagName("a"));
        System.out.println("count of layout links : "+ countOfLayoutLinks.size());
    }
}
