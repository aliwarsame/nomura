package nomura.com.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class CheckWindowsServiceStatus {
    WiniumDriver driver = null;
    String state = "";

    @Given("^virtualbox virtual machine installed with Windows (\\d+)$")
    public void virtualbox_virtual_machine_installed_with_Windows(String windowsVersion) {
        String appPath = "C:/windows/system32/notepad.exe";
        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(appPath);
        option.setDebugConnectToRunningApp(false);
        option.setLaunchDelay(2);
        try {
            driver = new WiniumDriver(new URL("http://192.168.56.101:9999"),option);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @When("^I inspect \"([^\"]*)\" for \"([^\"]*)\"$")
    public void I_inspect_for(String service, String property) throws InterruptedException {
        //driver.switchTo().frame("4100");
        Thread.sleep(1000);
        WebElement window =  driver.findElement(By.id("4100"));
        Thread.sleep(1000);
        WebElement textSearch = window.findElement(By.id("4101"));
        Thread.sleep(1000);
        //textSearch.click();
        Thread.sleep(1000);
        textSearch.sendKeys("PowerShell");
        Thread.sleep(1000);
        textSearch.submit();
        Thread.sleep(1000);
        WebElement cmd =  driver.findElement(By.id("Console Window"));
        WebElement textArea = driver.findElement(By.id("Text Area"));
        Thread.sleep(1000);
        textArea.sendKeys("Get-WMIObject -Class \"Win32_Service\" | Where{$_.Name -eq \"" + service + "\"} | Select \"" + property + "\" | Format-List");
        Thread.sleep(1000);
        textArea.submit();
        Thread.sleep(3000);
        //System.out.println("My command output : "  + textArea.getText());
        state = textArea.getText();
        WebElement windowsPowerShell = driver.findElement(By.name("Windows PowerShell"));
        WebElement closeTitleBar = windowsPowerShell.findElement(By.id("TitleBar")).findElement(By.name("Close"));
        closeTitleBar.click();
    }

    @Then("^the value should be \"([^\"]*)\"$")
    public void the_value_should_be(String value) {
        List<String> result2 = new ArrayList<String>();
        List<String> result = Arrays.asList(state.split("\\n"));
        for(String s: result){
            if(s.contains(" : ")){
                result2.add(s.replaceAll("\\r",""));
            }
        }
        //System.out.println(result2);
        Map<String, String> mapped = new HashMap<String, String>();
        for (String sp: result2){
            String [] array = new String[result2.size()];
            array = sp.split(":");
            mapped.put(array[0].trim(),array[1].trim());
        }

        for (Map.Entry<String, String> entry : mapped.entrySet()) {
            //System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            if(entry.getKey().equals("State")){
                state = entry.getValue();
            }
        }
        assertEquals(value, state);
    }

}
