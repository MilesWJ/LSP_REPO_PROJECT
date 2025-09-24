package org.howard.edu.lsp.assignment3;

public class ProductTransformer {
    public Product transform(int id, String name, double price, String category) {
        String tName = (name == null) ? "" : name.trim().toUpperCase();
        String tCategory = category == null ? "" : category.trim();

        if (equalsIgnoreCaseSafe(tCategory, "Electronics")) {
            price = price * 0.9;
            price = round2(price);
            if (price > 500.0) {
                tCategory = "Premium Electronics";
            }
        }

        String priceRange = classifyPrice(price);
        double tPrice = round2(price);

        return new Product(id, tName, tPrice, tCategory, priceRange);
    }

    private boolean equalsIgnoreCaseSafe(String a, String b) {
        return a != null && b != null && a.equalsIgnoreCase(b);
    }

    private double round2(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    private String classifyPrice(double price) {
        if (price <= 10.0) return "Low";
        if (price <= 100.0) return "Medium";
        if (price <= 500.0) return "High";
        return "Premium";
    }
}
