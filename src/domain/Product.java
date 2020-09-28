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
        if (!isValidId(id)) throw new IllegalArgumentException("Not a valid Id");
        this.id = Integer.parseInt(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getId() {
        return id;
    }

    public abstract double getPrice(int days);

    public int compareTo(Product p) {
        int c = 0;
        if (p.getClass() == this.getClass()) {
            c = this.getTitle().compareTo(p.getTitle());
            if (c == 0) c = this.getId() - p.getId();
        } else {
            if (this instanceof Movie || (this instanceof Game && p instanceof Cd)) {
                return -1;
            } else {
                return 1;
            }
        }
        return c;
    }

    public static boolean isValidId(String ids) {
        boolean valid = false;
        if (!(ids == null) && !ids.isEmpty()) {
            try {
                int id = Integer.parseInt(ids);
                if (id >= 0) valid = true;
            } catch (NumberFormatException ignored) {
            }
        }
        return valid;
    }
}