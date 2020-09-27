package domain;

import javax.swing.JOptionPane;

public class Product {
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

    public double getPrice(int days) {
        double price = 0;
        if(this.type.equals("M")) {
            price = 5;
            int daysLeft = days - 3;
            if (daysLeft > 0) {
                price += (daysLeft * 2);
            }
        } else if(this.type.equals("G")) {
            price = days * 3;
        }
        return price;
    }
}