/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author eliss
 */
public class utils {
    
    public WebDriver driver;
    
    public void setUpDriver(){
    
       System.setProperty("webdriver.chrome.driver", "E:\\Proyectos Netbeans\\driver\\chromedriver.exe");
               ChromeOptions options = new ChromeOptions();
              // options.setExperimentalOption("useAutomationExtension", false);
               driver = new ChromeDriver(options);
               driver.get("https://reqres.in/");
               driver.manage().window().maximize();
               driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
               
    }
    
}
