
                                                       //|
// raw code ....for exception handled code go down .....\|/
/*
 * package client;
 * 
 * import java.util.Scanner;
 * 
 * import entity.Product; import repository.ProductItems;
 * 
 * public class TestPMS {
 * 
 * public static void displayMenu() { System.out.println("________________");
 * System.out.println("choose an option"); System.out.println("1.Add Product");
 * System.out.println("2.Display product");
 * System.out.println("3.Remove product"); System.out.println("4.exit");
 * System.out.println("________________\n"); } public static void main(String[]
 * args) {
 * 
 * Scanner sc =new Scanner(System.in);
 * 
 * ProductItems productItems = new ProductItems();
 * 
 * while(true) { displayMenu(); int choice = sc.nextInt(); if(choice ==1) {
 * System.out.println("Adding product");
 * System.out.println("enter the product id"); int id = sc.nextInt();
 * System.out.println("enter the product name"); String name =sc.next();
 * ////vice versa to display in console
 * System.out.println("enter the product type"); String type =sc.next();
 * System.out.println("enter the product price"); int price = sc.nextInt();
 * System.out.println("enter the product quantity"); int quantity =
 * sc.nextInt(); Product p1 = new Product(id,name,type,price,quantity);
 * productItems.addProduct(p1);
 * 
 * } else if(choice ==2) { //System.out.println("display product ");
 * productItems.displayProducts();
 * 
 * 
 * } else if(choice ==3) { //System.out.println("remove product");
 * System.out.println("enter the product id"); int id = sc.nextInt();
 * if(productItems.removeProduct(id)) { System.out.println("product deleted");
 * 
 * } else { System.out.println("could not delete the product!!"); break; }
 * 
 * } else { System.out.println("thanks for visiting"); break; }
 * 
 * } sc.close(); }}
 */





// exception handled code

package client;

import java.util.InputMismatchException;
import java.util.Scanner;

import entity.Product;
import repository.ProductItems;

public class TestPMS {
    
    public static void displayMenu() {
        System.out.println("________________");
        System.out.println("Choose an option:");
        System.out.println("1. Add Product");
        System.out.println("2. Display Product");
        System.out.println("3. Remove Product");
        System.out.println("4. Exit");
        System.out.println("________________\n");
    }
    
    public static int getValidInt(Scanner sc) {
        int num = -1;
        while (true) {
            try {
                num = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();  // Clear the invalid input
            }
        }
        return num;
    }
    
    public static String getValidString(Scanner sc) {
        String input = "";
        while (true) {
            input = sc.next();
            if (input.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid string.");
            }
        }
        return input;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ProductItems productItems = new ProductItems();
        
        while (true) {
            displayMenu();
            int choice = getValidInt(sc);  // Validating menu choice
            
            switch (choice) {
                case 1:
                    System.out.println("Adding product");
                    
                    System.out.println("Enter the product ID (integer):");
                    int id = getValidInt(sc);
                    
                    System.out.println("Enter the product name:");
                    String name = getValidString(sc);  // Validating string input
                    
                    System.out.println("Enter the product type:");
                    String type = getValidString(sc);  // Validating string input
                    
                    System.out.println("Enter the product price (integer):");
                    int price = getValidInt(sc);  // Validating integer input
                    
                    System.out.println("Enter the product quantity (integer):");
                    int quantity = getValidInt(sc);  // Validating integer input
                    
                    Product p1 = new Product(id, name, type, price, quantity);
                    productItems.addProduct(p1);
                    System.out.println("Product added successfully!\n");
                    break;
                    
                case 2:
                    productItems.displayProducts();
                    break;
                    
                case 3:
                    System.out.println("Enter the product ID to remove:");
                    int removeId = getValidInt(sc);  // Validating integer input
                    if (productItems.removeProduct(removeId)) {
                        System.out.println("Product deleted successfully!\n");
                    } else {
                        System.out.println("Product not found! Could not delete.\n");
                    }
                    break;
                    
                case 4:
                    System.out.println("Thanks for visiting!");
                    sc.close();
                    return;  // Exit the program
                    
                default:
                    System.out.println("Invalid choice. Please choose a valid option.\n");
            }
        }
    }
}
