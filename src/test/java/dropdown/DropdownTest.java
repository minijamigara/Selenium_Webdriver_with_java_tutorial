package dropdown;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropdownTest extends BaseTest {


    @Test
    public void testSelectOption(){
        var dropdownPage = homePage.clickDropdown();

        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        var selectOptions = dropdownPage.getSelectedOption();
        assertEquals(selectOptions.size(),1,"Incorrect number of selections");
        assertTrue(selectOptions.contains(option),"option not selected");
    }
}
