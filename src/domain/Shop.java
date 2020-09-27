package domain;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Shop {
    private ArrayList<Product> products;

    public Shop() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product is null");
        products.add(product);
    }

    public void showProduct(String id) {
        Product product = findProduct(id);
        if (product != null) {
            JOptionPane.showMessageDialog(null, product.getTitle());
        } else throw new IllegalArgumentException("Product not found");
    }

    public void showPrice(String id) {
        Product product = findProduct(id);
        if (product != null) {
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = 0;
            try {
                days = Integer.parseInt(daysString);
                if (days < 0) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Not a valid number of days");
            }
            JOptionPane.showMessageDialog(null, product.getPrice(days));
        } else throw new IllegalArgumentException("Product not found");
    }

    public void showAllProducts() {
        String movies = "Movies:\n";
        String games = "\nGames:\n";
        String cds = "\nCDs:\n";
        for (Product p : products) {
            String pString = "Title: " + String.format("%-30s", p.getTitle()) + "Id: " + p.getId() + "\n";
            if (p instanceof Movie) {
                movies += pString;
            } else if (p instanceof Game) {
                games += pString;
            } else if (p instanceof Cd) {
                cds += pString;
            }
        }
        JOptionPane.showMessageDialog(null, movies + games + cds);
    }

    public Product findProduct(String ids) {
        int id;
        try {
            id = Integer.parseInt(ids);
            if (id < 0) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Not a valid id");
        }
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}