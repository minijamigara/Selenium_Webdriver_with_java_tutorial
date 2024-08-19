package hover;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HoverTest extends BaseTest {
    @Test
    public void testHoverUser1(){
        var hoversPage = homePage.cliickHovers();
        var caption = hoversPage.hoverOverFunctions(1);
        assertTrue(caption.isCaptionDisplayed(),"captio not displayed");
        assertEquals(caption.getTitle(),"name: user1","caption title incorrect");
        assertEquals(caption.getLinkText(),"View profile","caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"),"Link incorrect");

    }
}
