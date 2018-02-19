package nomura.com.utils;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WiniumMain {
    WiniumDriver driver = null;
    String appPath = "C:/windows/system32/notepad.exe";

    public WiniumMain(){
        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(appPath);
        option.setDebugConnectToRunningApp(false);
        option.setLaunchDelay(2);
        try {
            driver = new WiniumDriver(new URL("http://192.168.56.101:9999"),option);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    public WiniumDriver getDriver(){
        return driver;
    }

    @Test
    public void testCMD() throws InterruptedException, MalformedURLException {
        Thread.sleep(1000);
        WebElement windows =  driver.findElement(By.id("4100"));
        Thread.sleep(1000);
        WebElement textSearch = windows.findElement(By.id("4101"));
        Thread.sleep(1000);
        //textSearch.click();
        Thread.sleep(1000);
        textSearch.sendKeys("RegEdit");
        Thread.sleep(1000);
        textSearch.submit();
        Thread.sleep(1000);
        WebElement finishButton = driver.findElement(By.xpath("//*[contains(@name,'es')]"));
        finishButton.click();
        WebElement regEdit =  driver.findElementByClassName("RegEdit_RegEdit");
        WebElement closeTitleBar = regEdit.findElement(By.name("Computer\\\\HKEY_LOCAL_MACHINE\\\\SOFTWARE\\\\Microsoft\\\\Notpad\\\\DefaultFonts")).findElement(By.name("Close"));
        closeTitleBar.click();



//        WebElement window =  driver.findElement(By.id("40965"));
////        Thread.sleep(3000);
//        WebElement fileExplorer =  window.findElement(By.name("File Explorer"));
////        Thread.sleep(1000);
//        fileExplorer.click();
//        WebElement downloads = driver.findElement(By.name("Downloads"));
////        Thread.sleep(1000);
//        downloads.click();
////        Thread.sleep(1000);
//        WebElement zipFile = driver.findElement(By.id("1"));
////        Thread.sleep(1000);
//        zipFile.click();
////        Thread.sleep(1000);
//        Actions action = new Actions(driver);
//        action.moveToElement(zipFile).doubleClick().build().perform();
////        Thread.sleep(1000);
//        WebElement extractAllButton =  driver.findElement(By.name("Extract all"));
////        Thread.sleep(1000);
//        extractAllButton.click();
////        Thread.sleep(1000);
//        WebElement driverZip =  driver.findElement(By.name("Winium.Desktop.Driver.zip"));
//        WebElement closeTitleBar = driverZip.findElement(By.id("TitleBar")).findElement(By.name("Close"));
//        closeTitleBar.click();
//        WebElement finishButton = driver.findElement(By.id("cancelbutton"));
//        finishButton.click();
////        Thread.sleep(1000);
//

    }

    @After
    public void tearDown(){
        driver.close();
    }
}
