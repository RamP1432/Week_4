package com.tit.dynamiconlinemarketplace;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a product category
abstract class ProductCategory {
    private String name;

    public ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Specific product categories
class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

// Generic Product class with bounded type parameter
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            price -= price * (percentage / 100);
        }
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: " + price + ", Category: " + category.getName();
    }
}

// Product catalog to store various products
class ProductCatalog {
    private List<Product<? extends ProductCategory>> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product<? extends ProductCategory> product) {
        products.add(product);
    }

    public void displayProducts() {
        for (Product<? extends ProductCategory> product : products) {
            System.out.println(product);
        }
    }
}

// Main class to test the implementation
public class DynamicOnlineMarketPlace {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        // Adding products
        Product<BookCategory> book = new Product<>("The Great Gatsby", 15.99, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 25.99, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 699.99, new GadgetCategory());

        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        // Applying discount
        book.applyDiscount(10);
        shirt.applyDiscount(15);
        phone.applyDiscount(5);

        // Display products
        catalog.displayProducts();
    }
}

