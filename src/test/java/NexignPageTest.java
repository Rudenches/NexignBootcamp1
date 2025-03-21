import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class NexignPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {

         driver = new ChromeDriver();
    }

    @Test
    public void countNexignMentions() {

          driver.get("https://nexign.com/ru");



          String pageText = driver.findElement(By.tagName("body")).getText();

          WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".page-main__slide-wrapper.js-top-slide-wrapper"))));

          String pageText2 = element.getText();



          String fullPage = String.join(" ",pageText,pageText2);
          int count = countOccurrencesIgnoreCase(fullPage, "Nexign");


          System.out.println("Количество упоминаний 'Nexign': " + count);



          assertTrue(count > 0, "Слово 'Nexign' не найдено на странице");

    }

    private int countOccurrencesIgnoreCase(String text, String word) {
        String lowerText = text.toLowerCase();
        String lowerWord = word.toLowerCase();
        int count = 0;
        int index = 0;

        while ((index = lowerText.indexOf(lowerWord, index)) != -1) {
            count++;
            index += lowerWord.length();
        }

        return count;
    }
}
