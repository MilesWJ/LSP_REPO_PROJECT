package org.howard.edu.lsp.assignment3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ETLPipeline {
    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";
        if (args != null && args.length >= 2) {
            inputPath = args[0];
            outputPath = args[1];
        }

        PipelineStats stats = new PipelineStats();
        CSVReader reader = new CSVReader();
        CSVWriter writer = new CSVWriter();
        ProductTransformer transformer = new ProductTransformer();

        try {
            CSVReadResult readResult = reader.read(inputPath, stats);

            if (readResult.isEmptyInputFile()) {
                writer.writeHeaderOnly(outputPath);
                System.out.println("Empty input file. Output header written to " + outputPath);
                printSummary(stats, outputPath);
                return;
            }

            List<Product> transformed = new ArrayList<>();
            for (CSVReadResult.RawRow raw : readResult.getRawRows()) {
                try {
                    int productId = Integer.parseInt(raw.id);
                    double price = Double.parseDouble(raw.price);
                    Product product = transformer.transform(productId, raw.name, price, raw.category);
                    transformed.add(product);
                    stats.incrementRowsTransformed();
                } catch (NumberFormatException nfe) {
                    stats.incrementRowsSkipped();
                }
            }

            writer.write(outputPath, transformed);
            printSummary(stats, outputPath);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: " + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("I/O Error: " + ioe.getMessage());
        }
    }

    private static void printSummary(PipelineStats stats, String outputPath) {
        System.out.println("Run Summary:");
        System.out.println("Rows read: " + stats.getRowsRead());
        System.out.println("Rows transformed: " + stats.getRowsTransformed());
        System.out.println("Rows skipped: " + stats.getRowsSkipped());
        System.out.println("Output written to: " + outputPath);
    }
}
