package domain;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Shop {
    private ArrayList<Product> products;
    private static int id = 0;

    public Shop() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product is null");
        product.setId(id);
        products.add(product);
        id++;
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
        ArrayList<Product> productsSorted = new ArrayList<>();
        productsSorted.addAll(products);
        Collections.sort(productsSorted);

        String movies = "Movies:\n";
        String games = "\nGames:\n";
        String cds = "\nCDs:\n";
        for (Product p : productsSorted) {
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
        if (!Product.isValidId(ids)) throw new IllegalArgumentException("Not a valid Id");
        id = Integer.parseInt(ids);
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}