package domain;

public class Cd extends Product {

    public Cd(String title, String id, String type) {
        super(title, id, type);
    }

    public double getPrice(int days) {
        return days * 1.5;
    }
}
