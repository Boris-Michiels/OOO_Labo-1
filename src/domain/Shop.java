package domain;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Shop {
	
	private ArrayList<String> productTitles;
	private ArrayList<String> productTypes;
	private ArrayList<String> productIds;
	
	public Shop()
	{
		productTitles = new ArrayList<String>();
		productTypes = new ArrayList<String>();
		productIds = new ArrayList<String>();
	}

	public double getPrice(int productidx, int days) {
		double price = 0;
		if(productTypes.get(productidx).equals("M")){ 
			price = 5;
			int daysLeft = days - 3;
			if (daysLeft > 0) {
				price += (daysLeft * 2);
			}
		} else if(productTypes.get(productidx).equals("G")){ 
			price = days * 3;
		}
		return price;
	}
	
	public void addProduct() {
		String title = JOptionPane.showInputDialog("Enter the title:");
		String id = JOptionPane.showInputDialog("Enter the id:");
		String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");
		
		this.productTitles.add(title);
		this.productIds.add(id);
		this.productTypes.add(type);
	}
	
	public void showProduct(){
		String id = JOptionPane.showInputDialog("Enter the id:");
		int idx = -1;
		boolean found = false;
		for(int i = 0; i < this.productIds.size() && !found; i++)
		{
			if(this.productIds.get(i).equals(id))
			{
				idx = i;
				found = true;
			}
		}
		if(found)
		{
			JOptionPane.showMessageDialog(null, this.productTitles.get(idx));
		}		
	}

	public void showPrice(){
		String id = JOptionPane.showInputDialog("Enter the id:");
		int idx = -1;
		boolean found = false;
		for(int i = 0; i < this.productIds.size() && !found; i++){
			if(this.productIds.get(i).equals(id)){
				idx = i;
				found = true;
			}
		}
		if(found){
			String daysString = JOptionPane.showInputDialog("Enter the number of days:");
			int days = Integer.parseInt(daysString);
			JOptionPane.showMessageDialog(null, this.getPrice(idx,days));
		}
	}
}
