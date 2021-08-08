/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.regresin;

import com.jayway.jsonpath.JsonPath;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.json.*;


/**
 *
 * @author roberto
 */
public class regresin extends Utils.utils{
    
    
    @Test
    public void regresin() throws InterruptedException, JSONException {
    
     setUpDriver();
     WebDriverWait wait = new WebDriverWait(driver, 40);
     Thread.sleep(1000);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='t-center main-arrow']//i[@class='fa fa-arrow-circle-down']"))).isDisplayed();
     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0,1000)", "");
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='console']"))).isDisplayed();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='console']//ul//li[@data-id='users-single-not-found']"))).isDisplayed();
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='console']//ul//li[@data-id='users-single-not-found']"))).click();
     Thread.sleep(1000);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='response']//p//strong[text()='Response ']"))).isDisplayed();
     String response =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='response']//p//strong//span"))).getText();
     Assert.assertEquals("404", response);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='response']//pre"))).isDisplayed();
     String value =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='response']//pre"))).getText();
     Assert.assertEquals("{}", value);
     System.out.println(value);
     Thread.sleep(1000);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='console']//ul//li[@data-id='unknown-single']"))).isDisplayed();
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='console']//ul//li[@data-id='unknown-single']"))).click();
     Thread.sleep(1000);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='response']//p//strong[text()='Response ']"))).isDisplayed();
     String response1 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='response']//p//strong//span"))).getText();
     Assert.assertEquals("200", response1);   
     Thread.sleep(1000);
     String  value2 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='response']//pre"))).getText();
     JSONObject cad = new JSONObject(value2);
     String name = JsonPath.read(value2,"$.data.name");
     Assert.assertEquals("fuchsia rose", name);
     System.out.println("Name:" + name);
     Thread.sleep(100);
     JavascriptExecutor js2 = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0,125)", "");
    
     Thread.sleep(1000);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='console']//ul//li[@data-id='login-successful']"))).isDisplayed();
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='console']//ul//li[@data-id='login-successful']"))).click();
    Thread.sleep(1000);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='response']//p//strong[text()='Response ']"))).isDisplayed();
     String response2 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='response']//p//strong//span"))).getText();
     Assert.assertEquals("200", response2);  
     
     Thread.sleep(1000);
     String  value3 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='response']//pre"))).getText();
     JSONObject cad2 = new JSONObject(value3);
     String token = JsonPath.read(value3,"$.token");
     Assert.assertNotNull(token);
     System.out.println("Token value: " + token);
     driver.close();
    }
    
}
