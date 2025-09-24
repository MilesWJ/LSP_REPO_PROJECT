package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static final String HEADER = "ProductID,Name,Price,Category";

    public CSVReadResult read(String inputPath, PipelineStats stats) throws IOException {
        File inputFile = new File(inputPath);
        System.out.println("Looking for input at: " + inputFile.getAbsolutePath());

        if (!inputFile.exists()) {
            throw new FileNotFoundException("Input file not found at " + inputPath);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = reader.readLine();
            if (line == null) {
                return new CSVReadResult(new ArrayList<>(), true);
            }

            List<CSVReadResult.RawRow> rows = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    stats.incrementRowsSkipped();
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    stats.incrementRowsSkipped();
                    continue;
                }
                rows.add(new CSVReadResult.RawRow(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()));
                stats.incrementRowsRead();
            }
            return new CSVReadResult(rows, false);
        }
    }
}
