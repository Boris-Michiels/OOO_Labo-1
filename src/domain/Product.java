package domain;

public abstract class Product implements Comparable<Product> {
    private String title;
    private int id;

    public Product() {

    }

    public Product(String title, String id) {
        setTitle(title);
        setId(id);
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title is empty");
        this.title = title;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("Id is empty");
        try {
            this.id = Integer.parseInt(id);
        } catch (NumberFormatException ignored) {
            throw new IllegalArgumentException("Not a number");
        }
    }

    public String getTitle() {
        return this.title;
    }

    public int getId() {
        return this.id;
    }

    public abstract double getPrice(int days);

    public int compareTo(Product p) {
        int c = 0;
        c = this.getTitle().compareTo(p.getTitle());
        if (c == 0) c = this.getId() - p.getId();
        return c;
    }
}