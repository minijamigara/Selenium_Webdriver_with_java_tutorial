package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage {
    WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("#mceu_12 button");

    public  WYSIWYGEditorPage(WebDriver driver){
        this.driver = driver;
    }

    public void clearTextArea(){
        switchTOEditArea();
        driver.findElement(textArea).clear();
        switchTomainArea();
    }

    public void setTextArea(String text){
        switchTOEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchTomainArea();
    }

    private void switchTOEditArea(){
        driver.switchTo().frame(editorIframeId);
    }
    private void switchTomainArea(){
        driver.switchTo().parentFrame();
    }
    public String getTextFromEditor(){
        switchTOEditArea();
        String text = driver.findElement(textArea).getText();
        switchTomainArea();
        return text;
    }
    public void decreaseIndentation(){
        driver.findElement(decreaseIndentButton).click();
    }

}
