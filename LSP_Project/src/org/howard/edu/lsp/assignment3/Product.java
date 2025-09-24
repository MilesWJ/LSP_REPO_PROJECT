package org.howard.edu.lsp.assignment3;

/**
 * Represents a single product record flowing through the ETL pipeline.
 * Immutable after construction to keep transformations explicit.
 */
public class Product {
    private final int id;
    private final String name;      // transformed to uppercase during ETL
    private final double price;     // may be discounted/rounded during ETL
    private final String category;  // may be reclassified during ETL
    private final String priceRange;

    public Product(int id, String name, double price, String category, String priceRange) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = priceRange;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public String getPriceRange() { return priceRange; }

    public String toCSVRow() {
        return id + "," + name + "," + String.format("%.2f", price) + "," + category + "," + priceRange;
    }
}
