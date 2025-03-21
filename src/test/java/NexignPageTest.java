import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;



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

          int count = countOccurrencesIgnoreCase(pageText, "Nexign");

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
