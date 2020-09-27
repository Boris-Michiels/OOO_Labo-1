package domain;

public abstract class Product {
    private String title, type, id;

    public Product(String title, String id, String type) {
        this.title = title;
        this.id = id;
        this.type = type;
    }

    public String getTitle() {
        return this.title;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public abstract double getPrice(int days);
}