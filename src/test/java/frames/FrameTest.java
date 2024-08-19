package frames;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FrameTest extends BaseTest {
    WebDriver driver;

    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWYSIWYGEditor();
        editorPage.clearTextArea();

        String text1 = "hello";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndentation();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(), text1 + text2 , "Text from editor is wrong");
    }
}
