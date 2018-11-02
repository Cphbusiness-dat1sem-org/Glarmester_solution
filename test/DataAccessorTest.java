import glarmester.data.DataAccessor;
import glarmester.data.DataAccessorFile;
import glarmester.data.DataException;
import glarmester.data.Frame;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Tests any inserted DataAccessor
 * @author RODA
 */
public class DataAccessorTest {
    private DataAccessor da;
    
    public DataAccessorTest() {
        da = new DataAccessorFile();
    }
    
    @Test
    public void testGetFrames() throws DataException{
        List<Frame> frames = da.getFrames();
        assertNotNull(frames);

        int expected = 3;
        int actual = frames.size();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testGetFrame() throws DataException{
        Frame frame = da.getFrame("plain");
        assertNotNull(frame);

        String expectedName = "Plain";
        String actualName = frame.getName();
        assertEquals(expectedName, actualName);

        double expectedPrice = 100.0;
        double actualPrice = frame.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.005);
    }
    
    @Test(expected = DataException.class)
    public void negativTestGetFrame() throws DataException{
        da.getFrame("NapoleonBonaparte");
        da.getFrame("");
        da.getFrame(null);
        da.getFrame("Plain");
    }
    
    @Test
    public void testGetGlassPrice() throws DataException{
        double expectedPrice = 300.0;
        double actualPrice = da.getGlassPrice();
        assertEquals(expectedPrice, actualPrice, 0.005);
    }

}
