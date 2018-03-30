/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Administrator
 */
public class Question2 {

    /**
     * @param args the command line arguments
     */
    static WebDriver driver = null;
    public static void main(String[] args) {
        // TODO code application logic here
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\question2\\chromedriver.exe");
        driver =  new ChromeDriver();
        driver.navigate().to("https://www.weightwatchers.com/us/");
        String title = driver.getTitle();
        if(title.equals("Weight Loss Program, Recipes & Help | Weight Watchers")){
            System.out.println("Title matches");
        }
        driver.findElement(By.id("ela-menu-visitor-desktop-supplementa_find-a-meeting")).click();
        title = driver.getTitle();
        if(title.contains("Get Schedules & Times Near You")){
            System.out.println("Title contains");
        }
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementById('meetingSearch').setAttribute('value', '10010')");
        driver.findElement(By.id("meetingSearch")).sendKeys("10010");
        driver.findElement(By.id("meetingSearch")).submit();
        String name = driver.findElements(By.className("location__name")).get(0).getText();
        String distance = driver.findElements(By.className("location__distance")).get(0).getText();
        System.out.println("The name is " + name);
        System.out.println("The distance is " + distance);
        driver.findElements(By.className("meeting-location")).get(0).click();
        if(name.equals(driver.findElements(By.className("location__name")).get(0).getText())){
            System.out.println("The displayed location name matches with the name of the first searched result that was clicked");
        }
        String hours = driver.findElement(By.className("hours-list--currentday")).getText();
        System.out.println(hours);
    }
    
}
