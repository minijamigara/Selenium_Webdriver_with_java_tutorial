package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;

    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadFiles = By.id("uploaded-files");

    public  FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickuploadButton(){
        driver.findElement(uploadButton).click();
    }

    /**
     * @paraam absolutePathofFile The complete path of the file to upload
     */

    public void uploadFile (String absolutePathofFile){
        driver.findElement(inputField).sendKeys(absolutePathofFile);
        clickuploadButton();
    }

    public String getUploadedFiles(){
        return driver.findElement(uploadFiles).getText();
    }
}
