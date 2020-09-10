package Model;

import java.awt.Color;
import java.util.Hashtable;
import Model.PosJPanel;

public class Node {

    // This class is the main data for the whole program
    // We're saving nodes inside a Matrix which represents the grid of the main window
    // We'll save the distance to the neighbors by using a hashtable which saves all the connected nodes and their respective distance

    private int row;
    private int column;
    private Hashtable<Node, Double> neighbors;
    private PosJPanel panel;
    private Node predecessor;
    private double distance;

    /**
     * constructor to create object of type node
     * @param row given y coordinate
     * @param column given x coordinate
     * @param panel panel that's saved at that position in the grid
     */
    public Node(int row, int column, PosJPanel panel) {
        this.row = row;
        this.column = column;
        this.panel = panel;
        this.predecessor = null;
        this.distance = Integer.MAX_VALUE;

    }


    // Getters/Setters
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Color getColor() {
        return this.panel.getBackground();
    }

    public void setColor(Color color) {
        this.panel.setBackground(color);
    }

    public Hashtable<Node, Double> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Hashtable<Node, Double> neighbors) {
        this.neighbors = neighbors;
    }

    public PosJPanel getPanel() {
        return panel;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
