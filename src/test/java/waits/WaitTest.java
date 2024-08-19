package waits;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class WaitTest extends BaseTest {
    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!" , "Loaded text is wrong");

    }
}
