package org.howard.edu.lsp.assignment3;

public class PipelineStats {
    private int rowsRead = 0;
    private int rowsTransformed = 0;
    private int rowsSkipped = 0;

    public void incrementRowsRead() { rowsRead++; }
    public void incrementRowsTransformed() { rowsTransformed++; }
    public void incrementRowsSkipped() { rowsSkipped++; }

    public int getRowsRead() { return rowsRead; }
    public int getRowsTransformed() { return rowsTransformed; }
    public int getRowsSkipped() { return rowsSkipped; }
}
