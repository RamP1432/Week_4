package com.tit.mapinterface;

import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); // Store product prices
    private Map<String, Integer> cartItems = new LinkedHashMap<>(); // Maintain order of items added
    private TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>(); // Display items sorted by price

    // Add a product to the cart
    public void addProduct(String product, double price, int quantity) {
        productPrices.put(product, price);
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);

        // Add product to TreeMap sorted by price
        sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
    }

    // Remove a product from the cart
    public void removeProduct(String product) {
        if (cartItems.containsKey(product)) {
            double price = productPrices.get(product);
            cartItems.remove(product);
            productPrices.remove(product);

            // Remove from TreeMap
            sortedByPrice.get(price).remove(product);
            if (sortedByPrice.get(price).isEmpty()) {
                sortedByPrice.remove(price);
            }
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    // Display cart items in the order they were added
    public void displayCartItems() {
        System.out.println("Cart Items (In Order of Addition):");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + " : Quantity: " + entry.getValue() + ", Price: Rs." + productPrices.get(entry.getKey()));
        }
    }

    // Display items sorted by price
    public void displaySortedByPrice() {
        System.out.println("Cart Items (Sorted by Price):");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + ": Price: Rs." + entry.getKey() + ", Quantity: " + cartItems.get(product));
            }
        }
    }

    // Calculate the total cost
    public double getTotalCost() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }
}

public class ShippingCartManagement {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products
        cart.addProduct("Laptop", 1200.0, 1);
        cart.addProduct("Phone", 800.0, 2);
        cart.addProduct("Headphones", 200.0, 3);
        cart.addProduct("Mouse", 50.0, 1);
        cart.addProduct("Keyboard", 100.0, 1);

        // Display cart in order of addition
        System.out.println();
        cart.displayCartItems();

        // Display cart sorted by price
        System.out.println();
        cart.displaySortedByPrice();

        // Display total cost
        System.out.println("\nTotal Cost: Rs." + cart.getTotalCost());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Remove an item and show updated cart
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\nRemoving 'Phone' from the cart...");
        cart.removeProduct("Phone");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        cart.displayCartItems();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\nTotal Cost: Rs." + cart.getTotalCost());
    }
}

