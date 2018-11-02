import glarmester.data.DataAccessorDatabase;
import glarmester.logic.Controller;
import glarmester.logic.Controller_Impl;
import glarmester.logic.PriceCalculator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RODA
 */
public class ControllerTest {
    private Controller c;
    
    public ControllerTest() {
        c = new Controller_Impl(new DataAccessorDatabase(), new PriceCalculator());
    }
    
    @Test
    public void testGetFrameNames(){
        List<String> names = c.getFrameNames();
        
        int expected = 3;
        int actual = names.size();
        assertEquals(expected, actual);
        
        for(String name : names){
            assertNotNull(name);
            assertFalse(name.isEmpty());
            assertFalse(name.contains(" "));
        }
    }
    
    @Test
    public void testGetTotalPrice(){
        double expected, actual;
        
        expected = 1000;
        actual = c.getTotalPrice(160, 100, "plain");
        assertEquals(expected, actual, 0.1);
        
        expected = 1158;
        actual = c.getTotalPrice(30, 120, "Lavish");
        assertEquals(expected, actual, 0.1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void negativTestTotalPrice(){
        c.getTotalPrice(0, 100, "ornate");
        c.getTotalPrice(0, 0, "plain");
        c.getTotalPrice(-100, 100, "plain");
        c.getTotalPrice(160, 100, null);
        c.getTotalPrice(160, 100, "");
        c.getTotalPrice(160, 100, "Rainbow");
    }
}
