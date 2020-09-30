package domain;

public abstract class Product {
    String title;
    String id;

    public Product(String title, String id) {
        setTitle(title);
        setId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.trim().isEmpty() ||title == null) throw new IllegalArgumentException("Title can't be empty.");
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.trim().isEmpty() ||id == null) throw new IllegalArgumentException("Id can't be empty.");
        this.id = id;
    }

    public abstract double getPrice(int days);
}
