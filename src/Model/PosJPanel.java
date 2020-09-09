package Model;

import javax.swing.JPanel;

public class PosJPanel extends JPanel{  

    private int row;
    private int column;

    /**
     * Constructs a object of type JPanel, but also has the coordinates in the matrix saved to it
     * @param row
     * @param column
     */
    public PosJPanel(int row, int column) {
        this.row = row;
        this.column = column;
    }


    // Getters/Setters
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
