import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void DropDownTests() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");

    }


    @Test
    public void leafgroundpageDropDownTest() throws InterruptedException {
        //1.1) way to select values in basic dropdown

        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //1.2) get the number of dropdown options

        List<WebElement> listofOptions = select.getOptions();
        int size = listofOptions.size();
        System.out.println("Number of elements in dropdown :" + size);

        for (WebElement element : listofOptions) {
            System.out.println(element.getText());
        }

        //1.3) using sendkeys select dropdown value

        dropDown.sendKeys("Puppeteer");
        Thread.sleep(3000);


        //1.4) selecting value in a bootstrap dropdown

        WebElement dropdown2 = driver.findElement(By.xpath("//dev[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listofdropdown2values = driver.findElements(By.xpath("//dev[@id='j_idt87:country_items']/li"));
        for (WebElement element : listofdropdown2values) {
            String dropdownvalue = element.getText();
            if (dropdownvalue.equals("USA")) ;
            element.click();
            break;

        }

    }
        //02) google search pick a value from suggestions

        @Test
        public void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.co.uk/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> googlesearchList = driver.findElements(By.xpath("//ul[@role = 'listbox']/li//div[@class='wM6W7d']"));
        System.out.println(googlesearchList.size());
        for(WebElement element : googlesearchList){
            System.out.println(element.getText());
        }

        //03) handle hidden auto suggestions drop and search using DOM debugger trick
    }
}