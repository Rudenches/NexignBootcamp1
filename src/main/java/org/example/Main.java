package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.get("https://nexign.com/ru ");

        //WebElement input = driver.findElement(By.xpath("//textarea[@aria-label=\"Найти\"]"));
        WebElement prodAndSolutions = driver.findElement(By.xpath("//*[@id=\"block-menyusverkhunewru\"]" +
                "/ul/li[1]/span"));
        WebElement toolsForIt = driver.findElement(By.xpath("//*[@id=\"block-menyusverkhunewru\"]/ul" +
                "/li[1]/ul/li[5]/span"));
        WebElement negixnNord = driver.findElement(By.xpath("//*[@id=\"block-menyusverkhunewru\"]/ul/li" +
                "[1]/ul/li[5]/ul/li/ul[1]/li[2]/a"));

        prodAndSolutions.click();
        toolsForIt.click();
        negixnNord.click();

}
}