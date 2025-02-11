package com.tit.smartwarehousemanagement;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a warehouse item
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item: " + name + ", Price: " + price;
    }
}

// Specific item categories
class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }
}

// Generic storage class with bounded type parameter
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// Utility method to display all items using wildcards
class WarehouseUtils {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

// Main class to test the implementation
public class SmartWareHouse {
    public static void main(String[] args) {
        // Create storages for different types of items
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to storage
        electronicsStorage.addItem(new Electronics("Laptop", 1200));
        electronicsStorage.addItem(new Electronics("Smartphone", 800));

        groceriesStorage.addItem(new Groceries("Apples", 5));
        groceriesStorage.addItem(new Groceries("Milk", 2));

        furnitureStorage.addItem(new Furniture("Chair", 50));
        furnitureStorage.addItem(new Furniture("Table", 100));

        // Display items from different storages
        System.out.println("Electronics:");
        WarehouseUtils.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        WarehouseUtils.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture:");
        WarehouseUtils.displayItems(furnitureStorage.getItems());
    }
}
