package org.howard.edu.lsp.assignment3;

import java.util.List;

public class CSVReadResult {
    private final List<RawRow> rawRows;
    private final boolean emptyInputFile;

    public CSVReadResult(List<RawRow> rawRows, boolean emptyInputFile) {
        this.rawRows = rawRows;
        this.emptyInputFile = emptyInputFile;
    }

    public List<RawRow> getRawRows() { return rawRows; }
    public boolean isEmptyInputFile() { return emptyInputFile; }

    public static class RawRow {
        public final String id;
        public final String name;
        public final String price;
        public final String category;

        public RawRow(String id, String name, String price, String category) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.category = category;
        }
    }
}
