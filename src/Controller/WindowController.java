package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Model.Node;

public class WindowController {
    
    private static Dimension screenSize;
    private static int gridSize = 100; 
    private static Color mainPanelColor = new Color(0, 255, 0);
    private static Node[][] nodeMatrix;
    private static int startPointRow;
    private static int startPointColumn;
    private static int endPointRow;
    private static int endPointColumn;
    private static View.DijkstraMainPanel dijkstraMainPanel;
    private static View.DijkstraGridPanel dijkstraGridPanel;
    private static View.DijkstraControlPanel dijkstraControlPanel;
    

    public static void startProgram() {
        // Creates matrix of nodes
        nodeMatrix = new Node[WindowController.gridSize][WindowController.gridSize];
        
        
        // Creates MainPanel using the screensize
        WindowController.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int halvedScreenHeight = (int) screenSize.getHeight() / 2;
        
        // Creates the gridpanel jpanel by using 90% of the height
        dijkstraGridPanel = new View.DijkstraGridPanel(halvedScreenHeight, (int) (halvedScreenHeight * 0.9), gridSize);
        // Creates the control panel by using 10% of the height
        dijkstraControlPanel = new View.DijkstraControlPanel(halvedScreenHeight, (int) (halvedScreenHeight * 0.1));
        
        // Using half the screen size to make for both sizes to make sure the gui is quadratic and not too big
        dijkstraMainPanel = new View.DijkstraMainPanel(halvedScreenHeight, halvedScreenHeight, WindowController.gridSize, "Dijkstra - Single Source Shortest Path");

    }


    // Getters/Setters
    public static Node[][] getPanelMatrix() {
        return nodeMatrix;
    }

    public static void setPanelMatrix(Node[][] nodeMatrix) {
        WindowController.nodeMatrix = nodeMatrix;
    }

    public static Color getMainPanelColor() {
        return mainPanelColor;
    }

    public static void setMainPanelColor(Color mainPanelColor) {
        WindowController.mainPanelColor = mainPanelColor;
    }

    public static int getStartPointRow() {
        return startPointRow;
    }

    public static void setStartPointRow(int startPointRow) {
        WindowController.startPointRow = startPointRow;
    }

    public static int getStartPointColumn() {
        return startPointColumn;
    }

    public static void setStartPointColumn(int startPointColumn) {
        WindowController.startPointColumn = startPointColumn;
    }

    public static int getEndPointRow() {
        return endPointRow;
    }

    public static void setEndPointRow(int endPointRow) {
        WindowController.endPointRow = endPointRow;
    }

    public static int getEndPointColumn() {
        return endPointColumn;
    }

    public static void setEndPointColumn(int endPointColumn) {
        WindowController.endPointColumn = endPointColumn;
    }

    public static View.DijkstraMainPanel getDijkstraMainPanel() {
        return dijkstraMainPanel;
    }

    public static View.DijkstraGridPanel getDijkstraGridPanel() {
        return dijkstraGridPanel;
    }

    public static View.DijkstraControlPanel getDijkstraControlPanel() {
        return dijkstraControlPanel;
    }

    
}
