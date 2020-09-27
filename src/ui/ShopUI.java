package ui;

import domain.*;

import javax.swing.JOptionPane;

public class ShopUI {
    public static void main(String[] args) {
        Shop shop = new Shop();

        String menu = "1. Add product\n2. Show product\n3. Show rental price\n\n0. Quit";
        int choice = -1;

        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                String title = JOptionPane.showInputDialog("Enter the title:");
                String id = JOptionPane.showInputDialog("Enter the id:");
                String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");
                Product product= null;
                if (type.equals("G")) {
                    product = new Game(title, id, type);
                } else if (type.equals("M")) {
                    product = new Movie(title, id, type);
                }
                if (product != null) {
                    shop.addProduct(product);
                }
            } else if (choice == 2) {
                String id = JOptionPane.showInputDialog("Enter the id:");
                shop.showProduct(id);
            } else if (choice == 3) {
                String id = JOptionPane.showInputDialog("Enter the id:");
                shop.showPrice(id);
            }
        }
    }
}