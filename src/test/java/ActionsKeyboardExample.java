import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActionsKeyboardExample {


    WebDriver driver;

    @BeforeMethod
    public void keyboardOperationsTestsBrowserOpen() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void KeyBoardActionsTest1() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement googleSearchTextBox = driver.findElement(By.name("q"));
        googleSearchTextBox.sendKeys("welcome");


        Actions actions = new Actions(driver);
        //select  the text
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        Thread.sleep(5000);

        actions.keyDown(Keys.SHIFT).sendKeys("writing capital sentence").perform();
        Thread.sleep(5000);

        actions.keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
               .sendKeys("x")
               .build().perform();

        //to write in capital in a text box
//        actions.keyDown(googleSearchTextBox, Keys.SHIFT)
//                .sendKeys("learn with osanda")
//                .perform();

    }


    @Test
    public void KeyBoardActionsTest2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(4000);

        List<WebElement> selectable = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("Li count is :" + size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();
    }
    }



