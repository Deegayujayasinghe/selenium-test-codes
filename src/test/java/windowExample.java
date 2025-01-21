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

public class windowExample {


    WebDriver driver;

    @BeforeMethod
    public void WindowTestsPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(300);
    }

    @Test
    public void windowTests() throws InterruptedException {
        //1) click and confirm new window open

        String oldWindow = driver.getWindowHandle();
        System.out.println("parent window :" + oldWindow);

        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("handles size + " + handles.size());

        //first method - using foreach loop

//        for (String newWindow : handles) {
//            System.out.println(newWindow);
//            driver.switchTo().window(newWindow);
//            System.out.println("page title is : " + driver.getTitle());
//        }
//
//        driver.close();
//
//        driver.switchTo().window(oldWindow);

        //second method - using list

        List<String> list = new ArrayList<>(handles); //converting set to list
        if (list.size() > 1 ) {
            driver.switchTo().window(list.get(1));
            System.out.println("child tab title is :" + driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);
        }

        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openbuttonVisibility = openButton1.isDisplayed();
        System.out.println("Open button Visibility " + openbuttonVisibility);

        //2 find the number of element

        WebElement multiWindowButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
        multiWindowButton.click();
        Thread.sleep(3000);

        Set<String> multiWindows = driver.getWindowHandles();
        int howmanyWindows = multiWindows.size();
        System.out.println("No of windows opened" + howmanyWindows);


        //3) close all windows except primary

        WebElement dontclosemeButton = driver.findElement(By.id("j_idt88:j_idt93"));
        dontclosemeButton.click();
        Thread.sleep(3000);

        Set<String> newWindowHandles = driver.getWindowHandles();
        for (String allwindows : newWindowHandles){
            if (!allwindows.equals(oldWindow)) {
                driver.switchTo().window(allwindows);
                driver.close();
            }
        }
//        driver.switchTo().window(oldWindow);
//        driver.close(); //close singe browser window driver which on focus

        driver.quit(); //close all browser windows
        }

    }




