package glarmester.data;

public class DataException extends Exception {

    public DataException() {
    }
    public DataException(String msg) {
        super(msg);
    }
    public DataException(String msg, Throwable thrwbl) {
        super(msg, thrwbl);
    }
    public DataException(Throwable thrwbl) {
        super(thrwbl);
    }
}