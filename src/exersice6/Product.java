package exersice6;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author dark_
 */
public class Product {

    HashMap<String, Double> productsMap = new HashMap<>();

    private static Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    public void menu() {
        System.out.println(
                "\n|MENU|\n"
                + "1) Enter new product.\n"
                + "2) List of products.\n"
                + "3) Change price.\n"
                + "4) Delete produc.\n"
                + "5) Exit.\n"
        );
        userAnswer();
    }

    public void userAnswer() {
        System.out.print("Enter an option: ");
        String answer = read.next();

        optionSwitch(answer);
    }

    public void optionSwitch(String answer) {

        switch (answer.toLowerCase()) {
            case "1":
                createProduc();
                menu();
                break;
            case "2":
                viewProductList();
                menu();
                break;
            case "3":
                changePrice();
                menu();
                break;
            case "4":
                deleteProduct();
                menu();
                break;
            case "5":
                System.out.println("Success on exit!");
                break;
            default:
                System.out.println("Enter a valid option.");
                menu();
                break;
        }

    }

    public void createProduc() {

        System.out.println("Enter product name: ");
        String productName = read.next();
        System.out.println("Enter product price: ");
        double productPrice = read.nextDouble();

        addProduct(productName, productPrice);
    }

    public void addProduct(String product, double price) {
        productsMap.put(product, price);
    }

    public void viewProductList() {
        for (Map.Entry<String, Double> prod : productsMap.entrySet()) {
            System.out.println("Product: " + prod.getKey() + ", Precio: $" + prod.getValue() + " |");
        }

    }

    public void deleteProduct() {
        System.out.println("Enter the name of the product to delete: ");
        String prod = read.next();

        if (productsMap.containsKey(prod)) {
            productsMap.remove(prod);
            System.out.println("Success!");
        } else {
            System.out.println("The product was not found.");
        }
    }

    public void changePrice() {
        System.out.println("Enter the name of the product to update: ");
        String producSearch = read.next();
        boolean findProduct = false;

        for (Map.Entry<String, Double> product : productsMap.entrySet()) {
            if (product.getKey().equalsIgnoreCase(producSearch)) {
                System.out.println("Product found!");
                System.out.print("Enter new price: ");
                double newPrice = read.nextDouble();
                product.setValue(newPrice);
                findProduct = true;
            }
        }
        if (findProduct) {
            System.out.println("Successfully modified price!");
        } else {
            System.out.println("Product not found");
        }

    }

}
