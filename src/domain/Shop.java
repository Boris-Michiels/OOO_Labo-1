package domain;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Shop {
	private ArrayList<Product> products;
	
	public Shop() {
		products = new ArrayList<>();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void showProduct(String id){
		Product product = findProduct(id);
		if(product != null) {
			JOptionPane.showMessageDialog(null, product.getTitle());
		}		
	}

	public void showPrice(String id){
		Product product = findProduct(id);
		if(product != null) {
			String daysString = JOptionPane.showInputDialog("Enter the number of days:");
			int days = Integer.parseInt(daysString);
			JOptionPane.showMessageDialog(null, product.getPrice(days));
		}
	}

	public Product findProduct(String id) {
		int idx = -1;
		for(Product product : products) {
			if(product.getId().equals(id)) {
				return product;
			}
		}
		return null;
	}
}