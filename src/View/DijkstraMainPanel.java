package View;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import Controller.WindowController;

public class DijkstraMainPanel extends JFrame{

    public DijkstraMainPanel (int width, int height, int gridSize, String name){
        super(name);

        setSize(width, height);
        setLocationRelativeTo(null);        // Centers application when you open it
        setLayout(new BorderLayout());      // Using BorderLayout, because there are only 2 jpanels inside this jframe
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Adds the gridpanel into the center of the jframe
        add(WindowController.getDijkstraGridPanel(), BorderLayout.CENTER);
        // Adds the controlpanel to the bottom of the frame
        add(WindowController.getDijkstraControlPanel(), BorderLayout.SOUTH);

        setFocusable(true);
        setVisible(true);
    }



}
