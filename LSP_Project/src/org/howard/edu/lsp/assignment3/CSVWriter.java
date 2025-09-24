package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.List;

public class CSVWriter {
    public static final String OUTPUT_HEADER = "ProductID,Name,Price,Category,PriceRange";

    public void write(String outputPath, List<Product> products) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(OUTPUT_HEADER);
            writer.newLine();
            for (Product p : products) {
                writer.write(p.toCSVRow());
                writer.newLine();
            }
        }
    }

    public void writeHeaderOnly(String outputPath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(OUTPUT_HEADER);
            writer.newLine();
        }
    }
}
