package glarmester.data;

public class Frame {
    private String name;
    private double price;

    public Frame(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Frame{" + "name=" + name + ", price=" + price + '}';
    }
}
