package ui;

import domain.*;

import javax.swing.JOptionPane;

public class ShopUI {
    public static void main(String[] args) {
        Shop shop = new Shop();

        String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Show all products\n\n0. Quit";
        String[] menuArray = menu.split("\n");
        int maxChoice = Integer.parseInt(menuArray[menuArray.length - 3].split("\\.")[0]);
        int choice = -1;

        while (choice != 0) {
            choice = -1;
            try {
                String choiceString = JOptionPane.showInputDialog(menu);
                if (choiceString == null) choice = 0;
                else choice = Integer.parseInt(choiceString);
                if (choice > maxChoice || choice < 0) throw new IllegalArgumentException();
            } catch (IllegalArgumentException ignored) {
                JOptionPane.showMessageDialog(null, "Please choose a number from 0 to " + maxChoice);
            }

            if (choice == 1) {
                String typeMenu = "1. Movie\n2. Game\n3. Cd\n\n0. Cancel";
                String[] typeMenuArray = typeMenu.split("\n");
                int maxTypeChoice = Integer.parseInt(typeMenuArray[typeMenuArray.length - 3].split("\\.")[0]);
                int typeChoice = -1;

                while (typeChoice < 0 || typeChoice > maxTypeChoice) {
                    try {
                        String typeChoiceString = JOptionPane.showInputDialog(typeMenu);
                        if (typeChoiceString == null) typeChoice = 0;
                        else typeChoice = Integer.parseInt(typeChoiceString);
                        if (typeChoice > maxChoice || typeChoice < 0) throw new IllegalArgumentException();
                    } catch (IllegalArgumentException ignored) {
                        JOptionPane.showMessageDialog(null, "Please choose a number from 0 to " + maxTypeChoice);
                    }
                }

                if (typeChoice == 0) continue;
                Product product = null;
                if (typeChoice == 1) {
                    product = new Movie();
                } else if (typeChoice == 2) {
                    product = new Game();
                } else if (typeChoice == 3) {
                    product = new Cd();
                }
                try {
                    if (product == null) throw new IllegalArgumentException("Product is null");
                    String title = JOptionPane.showInputDialog("Enter the title:");
                    product.setTitle(title);
                    shop.addProduct(product);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (choice == 2) {
                String id = null;
                while (!Product.isValidId(id)) {
                    id = JOptionPane.showInputDialog("Enter the id:");
                    try {
                        if (id == null) break;
                        shop.showProduct(id);
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            } else if (choice == 3) {
                String id = null;
                while (!Product.isValidId(id)) {
                    id = JOptionPane.showInputDialog("Enter the id:");
                    try {
                        if (id == null) break;
                        shop.showPrice(id);
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            } else if (choice == 4) {
                shop.showAllProducts();
            }
        }
    }
}