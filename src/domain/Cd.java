package domain;

public class Cd extends Product {

    public Cd() {

    }

    public Cd(String title, String id) {
        super(title, id);
    }

    public double getPrice(int days) {
        return days * 1.5;
    }
}