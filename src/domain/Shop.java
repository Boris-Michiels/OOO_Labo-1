package domain;

import java.util.ArrayList;

public class Shop {
    String name;
    ArrayList<Product> productDatabase;

    public Shop(String name){
        this.name = name;
        this.productDatabase = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.productDatabase.add(product);
    }

    public Product getProduct(String title){
        Product p = null;
        for (Product iterator: this.productDatabase) {
            if (title.equals(iterator.getTitle())) p = iterator;
        }
        return p;
    }

    public ArrayList<Product> getProducts(){
        return this.productDatabase;
    }


}
