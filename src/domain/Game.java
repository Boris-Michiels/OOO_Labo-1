package domain;

public class Game extends Product {

    public Game() {

    }

    public Game(String title, String id) {
        super(title, id);
    }

    public double getPrice(int days) {
        return days * 3;
    }
}