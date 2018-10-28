package glarmester.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataAccessorDatabase implements DataAccessor {

    @Override
    public List<Frame> getFrames() throws DataException {
        try {
            DBConnector c = new DBConnector();
            String query = "SELECT * FROM `prices`;";
            Statement stmt = c.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            List<Frame> list = new ArrayList<>();
            while(rs.next()){
                String product = rs.getString("product");
                double price = rs.getDouble("price");
                if("glass".equalsIgnoreCase(product)) continue;
                Frame frame = new Frame(product, price);
                list.add(frame);
            }
            return list;
        } catch (SQLException ex) {
            throw new DataException(ex);
        }
    }

    @Override
    public Frame getFrame(String name) throws DataException {
        if(name == null) throw new DataException("Name cannot be null!");
        try {
            DBConnector c = new DBConnector();
            String query = "SELECT * FROM `prices` WHERE `product` = '" + name.toLowerCase() + "';";
            Statement stmt = c.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                String product = rs.getString("product");
                double price = rs.getDouble("price");
                Frame frame = new Frame(product, price);
                return frame;
            }
            throw new DataException("Frame not found! - "+name);
        } catch (SQLException ex) {
            throw new DataException(ex);
        }
    }

    @Override
    public double getGlassPrice() throws DataException {
        try {
            DBConnector c = new DBConnector();
            String query = "SELECT * FROM `prices` WHERE `product` = 'glass';";
            Statement stmt = c.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                double price = rs.getDouble("price");
                return price;
            }
            throw new DataException("Glass price not found!");
        } catch (SQLException ex) {
            throw new DataException(ex);
        }
    }

}
