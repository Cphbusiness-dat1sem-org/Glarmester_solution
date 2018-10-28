package glarmester.data;

import java.io.FileReader;
import java.io.IOException;
import static glarmester.logic.Controller_Impl.DEBUG;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class DataAccessorFile implements DataAccessor {
    private String FILENAME = "data.txt";
    private double glassPrice = Double.NaN;
    private ArrayList<Frame> frames = new ArrayList<>();
    
    public DataAccessorFile() throws DataException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILENAME));
            String line;
            while((line = reader.readLine()) != null){
                line = line.toLowerCase();
                String name = line.split(":")[0].trim();
                String _value = line.split(":")[1].trim();
                double value = Double.parseDouble(_value);
                if("glass".equalsIgnoreCase(name)) glassPrice = value;
                else {
                    Frame frame = new Frame(name, value);
                    frames.add(frame);
                }
            }
        } catch (IOException ex) {
            if(DEBUG)ex.printStackTrace();
            throw new DataException(ex);
        }
    }

    @Override
    public List<Frame> getFrames() throws DataException {
        if(frames == null || frames.isEmpty())
            throw new DataException("No frames found!");
        return frames;
    }

    @Override
    public Frame getFrame(String name) throws DataException {
        for(Frame frame : frames){
            if(frame.getName().equalsIgnoreCase(name))
                return frame;
        }
        throw new DataException("Frame not found! - "+name);
    }

    @Override
    public double getGlassPrice() throws DataException {
        if(glassPrice == Double.NaN)
            throw new DataException("Glass price not found!");
        return glassPrice;
    }

    
    
}
