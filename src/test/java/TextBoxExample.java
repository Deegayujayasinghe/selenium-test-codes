import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {


    WebDriver driver;

    @BeforeMethod
    public void TextBoxtests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void textBoxTests(){


        //01 type your name

        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("osanda deegayu");



        //02 append county to this city

        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("india");



        //03 verify if text box

        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is text box enabled" + enabled );



        //04 clear the typed text

        driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));



        //05 retrieve the typed text

        WebElement textElemnt = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElemnt.getAttribute("value");
        System.out.println(value);



        //06 type email and tab.confirm control moved to next element.
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("osandadeegayu@gmail.com" + Keys.TAB + "confirmed control moved to next element");

    }
}
