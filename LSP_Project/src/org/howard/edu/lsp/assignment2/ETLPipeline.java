package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class ETLPipeline {
    public static void main(String[] args) {
        String input_path = "data/products.csv";
        String output_path = "data/transformed_products.csv";

        int rows_read = 0;
        int rows_transformed = 0;
        int rows_skipped = 0;

        ArrayList<String> transformed_rows = new ArrayList<String>();

        try {
            File input_file = new File(input_path);

            // Debug line
            System.out.println("Looking for input at: " + input_file.getAbsolutePath());

            if (!input_file.exists()) {
                System.out.println("Error: Input file not found at " + input_path);
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(input_file));
            String line = reader.readLine(); // read header

            if (line == null) {
                // empty file, just write header to output
                BufferedWriter writer = new BufferedWriter(new FileWriter(output_path));
                writer.write("ProductID,Name,Price,Category,PriceRange");
                writer.newLine();
                writer.close();
                System.out.println("Empty input file. Output header written to " + output_path);
                reader.close();
                return;
            }

            // add header for output
            transformed_rows.add("ProductID,Name,Price,Category,PriceRange");

            // read each row
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    rows_skipped++;
                    continue;
                }

                rows_read++;
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    rows_skipped++;
                    continue;
                }

                try {
                    int product_id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim().toUpperCase();
                    double price = Double.parseDouble(parts[2].trim());
                    String category = parts[3].trim();

                    // discount if Electronics
                    if (category.equalsIgnoreCase("Electronics")) {
                        price = price * 0.9;
                        price = round(price);

                        if (price > 500.0) {
                            category = "Premium Electronics";
                        }
                    }

                    String price_range = classify_price(price);

                    String new_row = product_id + "," + name + "," + 
                                     String.format("%.2f", price) + "," + 
                                     category + "," + price_range;

                    transformed_rows.add(new_row);
                    rows_transformed++;
                } catch (NumberFormatException e) {
                    rows_skipped++;
                }
            }

            reader.close();

            // write output
            BufferedWriter writer = new BufferedWriter(new FileWriter(output_path));
            for (String row : transformed_rows) {
                writer.write(row);
                writer.newLine();
            }
            writer.close();

            System.out.println("Run Summary:");
            System.out.println("Rows read: " + rows_read);
            System.out.println("Rows transformed: " + rows_transformed);
            System.out.println("Rows skipped: " + rows_skipped);
            System.out.println("Output written to: " + output_path);

        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }

    // round to 2 decimals using Math.round
    private static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    private static String classify_price(double price) {
        if (price <= 10.0) return "Low";
        if (price <= 100.0) return "Medium";
        if (price <= 500.0) return "High";
        return "Premium";
    }
}
