package domain;

import java.util.ArrayList;

public class Shop {
    String shopName;
    ArrayList<Product> productDatabase;

    public Shop(String name){
        this.shopName = name;
        productDatabase = new ArrayList<>();
    }

    public void addProduct(Product product){
        productDatabase.add(product);
    }
    public Product getProduct(String title){
        Product p = null;
        for (Product iterator: productDatabase
             ) {
            if (title.equals(iterator.getTitle())) p = iterator;
        }
        return p;
    }
    public ArrayList<Product> getProducts(){
        return productDatabase;
    }


}
