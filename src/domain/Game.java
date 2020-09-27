package domain;

public class Game extends Product {

    public Game(String title, String id, String type) {
        super(title, id, type);
    }

    public double getPrice(int days) {
        return days * 3;
    }
}