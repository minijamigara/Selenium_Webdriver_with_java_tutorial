package fileupload;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FileUploadTest extends BaseTest {
    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("E:\\QA Proj\\Selenium Webdriver With Java Course\\SeleniumProj1\\resources\\chromedriver.exe");
        assertEquals(uploadPage.getUploadedFiles(),"chromedriver.exe","File not uploaded");
    }
}
