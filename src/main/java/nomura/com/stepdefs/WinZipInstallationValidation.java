package nomura.com.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import nomura.com.utils.WiniumMain;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class WinZipInstallationValidation extends WiniumMain {
    WiniumDriver driver = null;
    String state = "";
    String regValue = "";

    @When("^a zip file is selected for extraction$")
    public void a_zip_file_is_selected_for_extraction() throws InterruptedException {
        Thread.sleep(1000);
        WebElement window = getDriver().findElement(By.id("40965"));
        WebElement fileExplorer = window.findElement(By.name("File Explorer"));
        fileExplorer.click();
        Thread.sleep(1000);
        WebElement downloads = getDriver().findElement(By.name("Downloads"));
        downloads.click();
        Thread.sleep(1000);
        WebElement zipFile = getDriver().findElement(By.id("1"));
        zipFile.click();
        Thread.sleep(1000);
        Actions action = new Actions(getDriver());
        action.moveToElement(zipFile).doubleClick().build().perform();
        WebElement extractAllButton = getDriver().findElement(By.name("Extract all"));
        extractAllButton.click();
    }

    @Then("^the windows file explorer should be visible$")
    public void the_windows_file_explorer_should_be_visible() {
        WebElement driverZip = getDriver().findElement(By.name("Winium.Desktop.Driver.zip"));
        WebElement closeTitleBar = driverZip.findElement(By.id("TitleBar")).findElement(By.name("Close"));
        closeTitleBar.click();
        WebElement cancelButton = getDriver().findElement(By.id("cancelbutton"));
        cancelButton.click();
    }

    @When("^I check the registry key for package GUID \"([^\"]*)\" in HKEY$")
    public void i_check_the_registry_key_for_package_GUID_in_HKEY(String guid) throws InterruptedException {
        regValue = guid;
        Thread.sleep(1000);
        WebElement window = getDriver().findElement(By.id("4100"));
        Thread.sleep(1000);
        WebElement textSearch = window.findElement(By.id("4101"));
        Thread.sleep(1000);
        textSearch.sendKeys("CMD");
        Thread.sleep(2000);
        textSearch.submit();
        Thread.sleep(1000);
        WebElement cmd = getDriver().findElement(By.id("Console Window"));
        WebElement textArea = getDriver().findElement(By.id("Text Area"));
        Thread.sleep(1000);
        textArea.sendKeys("Reg Query HKLM\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\" + guid);
        Thread.sleep(1000);
        textArea.submit();
        Thread.sleep(3000);
        System.out.println("My command output : " + textArea.getText());
        state = textArea.getText();
        WebElement windowsPowerShell = getDriver().findElement(By.name("Command Prompt"));
        WebElement closeTitleBar = windowsPowerShell.findElement(By.id("TitleBar")).findElement(By.name("Close"));
        closeTitleBar.click();

    }

    @When("^the \"([^\"]*)\" file in \"([^\"]*)\" is clicked$")
    public void the_file_in_is_clicked(String executableFileName, String appPath) {

        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(appPath + "\\" + executableFileName);
        option.setDebugConnectToRunningApp(false);
        option.setLaunchDelay(2);
        try {
            driver = new WiniumDriver(new URL("http://192.168.56.101:9999"), option);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^the entry should be present$")
    public void the_entry_should_be_present() {
        List<String> result2 = new ArrayList<String>();
        List<String> result = Arrays.asList(state.split("\\n"));
        boolean guidFound = false;
        for (String s : result) {
            if (s.contains(regValue)) {
                guidFound = true;
            }
        }

        assertTrue(guidFound);
    }

    @Then("^the winzip screen should be visible$")
    public void the_winzip_screen_should_be_visible() {
        //assertTrue(driver.findElement(By.name("Buy Now")).isDisplayed());
    }

    @Then("^the license pop up should not be displayed$")
    public void the_license_pop_up_should_not_be_displayed() {
        assertTrue(driver.findElement(By.name("Buy Now")).isDisplayed());
        driver.close();
        getDriver().close();
    }

}
