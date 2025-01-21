import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FrameExample {


    WebDriver driver;

    @BeforeMethod
    public void frameTestsPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");

    }

    @Test
    public void frameTests() {

        //1) click me inside frame
        driver.switchTo().frame(0);
        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String afterClickButtonText = button1.getText();
        System.out.println("After click inside frame button test" + afterClickButtonText);

        //2) click me (inside nested frame)

        driver.switchTo().defaultContent();
        driver.switchTo().frame(2); // inside into third frame
        driver.switchTo().frame("frame2"); // inside into third frame

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedFrameButtonText = button3.getText();
        System.out.println("After click inside frame button test" + afterClickNestedFrameButtonText);

        //3) How many frames in this page

        driver.switchTo().defaultContent();

        List<WebElement> getIframeTagCount = driver.findElements(By.tagName("iframe"));
        int size = getIframeTagCount.size();
        System.out.println("Iframe tag count :" + size);

        for (WebElement iframeElemnt : getIframeTagCount) {
            String frameSRCattributeValue = iframeElemnt.getAttribute("src");
            System.out.println("frame src attribute value :" + frameSRCattributeValue);
        }

    }
}