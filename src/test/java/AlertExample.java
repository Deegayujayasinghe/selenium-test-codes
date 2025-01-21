import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

    WebDriver driver;

    @BeforeMethod
    public void AlertTestsPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alertTests() throws InterruptedException {
        //1) alert (simple)

        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();


        //2) alert (confirm dialog)

        WebElement confirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBox.click();
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.dismiss();


        //3) alert (prompt dialog)

        WebElement promtBox = driver.findElement(By.id("j_idt88:j_idt104"));
        promtBox.click();
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(3000);
        String alertText = alert2.getText();
        System.out.println("Alert text is :" + alertText);
        alert2.sendKeys("My name is osanda");
        alert2.accept();

    }
}
