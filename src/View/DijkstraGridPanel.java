package View;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import Controller.WindowController;
import Model.Node;
import Model.PosJPanel;
import java.util.Hashtable;

public class DijkstraGridPanel extends JPanel {
    
    private Node[][] nodeMatrix;
    private boolean mouseIsPressed;
    private boolean startPointSet;
    private boolean endPointSet;
    private int gridSize;

    public DijkstraGridPanel(int width, int height, int gridSize) {

        this.mouseIsPressed = false;
        this.startPointSet = false;
        this.endPointSet = false;

        this.gridSize = gridSize;
        
        setSize(width, height);
        // This is the main action frame, we're using a gridlayout
        setLayout(new GridLayout(gridSize, gridSize));

        // locally saves the matrix of nodes stored in the WindowController
        nodeMatrix = WindowController.getPanelMatrix();

        // Iterates over nodematrix
        // Creates a new node at each position and saves the reference in the matrix
        // Also already creates a jpanel in each node and adds it to the gridPanel
        for (int row = 0; row < nodeMatrix.length; row++){
            for (int column = 0; column < nodeMatrix[row].length; column++){
                Node temp = new Node(row, column, createPosJPanel(row, column, WindowController.getMainPanelColor()));
                add(temp.getPanel());
                nodeMatrix[row][column] = temp;
            }
        }

        // Adds a mouse listener to keep track of the mouse leftclick status (this one is used so you can start dragging from slightly outside the matrix to draw more smoothly)
        addMouseListener(new trackMouseStatus());
        
        setVisible(true);
    }

    
    public void fetchNeighbors() {
        // Iterates over whole nodeMatrix to set the neighbors for each node
        for (int row = 0; row < nodeMatrix.length; row++){
            for (int column = 0; column < nodeMatrix[row].length; column++){
                // Creates the hashtable used to save the neighbors and their distances
                Hashtable<Node, Double> neighbors = new Hashtable<>();
                nodeMatrix[row][column].setNeighbors(neighbors);
                // Iterates over all adjacent nodes of current node 
                // Starts at top left and goes to the right, then one row down, etc.
                for (int y = row - 1; y <= row + 1; y++){
                    for (int x = column - 1; x <= column + 1; x++){
                        // Check if the coordinates we're looking at are still in the matrix
                        if (withinMatrixBounds(y, x)){
                            // Check if the color is still the original one (it's not an obstacle)
                            if (originalColorCheck(y, x)) {
                                // Checks if the current node is not our "source" node
                                if (x != column || y != row) {
                                    // If it's either purely vertical or purely horizontal the distance should be 1
                                    if (y == row || x == column){
                                        neighbors.put(nodeMatrix[y][x], (double) 1);
                                    }
                                    // If it's diagonal to the source node, the distance should be 1.44
                                    else {
                                        neighbors.put(nodeMatrix[y][x], Math.sqrt(2));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(nodeMatrix[0][0].getNeighbors());

    }

    private boolean withinMatrixBounds(int y, int x){
        if (x >= 0 && y >= 0 && x < gridSize && y < gridSize) {
            return true;
        }
        return false;
    }

    private boolean originalColorCheck(int y, int x){
        if (nodeMatrix[y][x].getColor() == WindowController.getMainPanelColor()){
            return true;
        }
        return false;
    }

    /**
     * Creates a new JPanel and returns it
     * Also adds a mouseListener (to be able to "draw" on it)
     * @return
     */ 
    public PosJPanel createPosJPanel(int row, int column, Color panelColor) {
        PosJPanel tempPanel = new PosJPanel(row, column);
        tempPanel.setBackground(panelColor);;
        tempPanel.setVisible(true);
        tempPanel.addMouseListener(new View.ChangeBackgroundAdapter(tempPanel));
        return tempPanel;
    }


    // Getters/Setters
    public boolean isMouseIsPressed() {
        return mouseIsPressed;
    }

    public void setMouseIsPressed(boolean mouseIsPressed) {
        this.mouseIsPressed = mouseIsPressed;
    }

    public boolean isStartPointSet() {
        return startPointSet;
    }

    public void setStartPointSet(boolean startPointSet) {
        this.startPointSet = startPointSet;
    }

    public boolean isEndPointSet() {
        return endPointSet;
    }

    public void setEndPointSet(boolean endPointSet) {
       this.endPointSet = endPointSet;
    }

}
