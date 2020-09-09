package View;

import java.awt.event.MouseEvent;
import Controller.WindowController;
import java.awt.event.MouseAdapter;
import Model.PosJPanel;
import java.awt.Color;

public class ChangeBackgroundAdapter extends MouseAdapter{

    PosJPanel panel;

    public ChangeBackgroundAdapter(PosJPanel panel) {
        this.panel = panel;
    }

    public void mouseClicked(MouseEvent event){
        // Sets the start point if the start point has not been set yet
        if (!WindowController.getDijkstraGridPanel().isStartPointSet()){
            panel.setBackground(new Color(0, 0, 0));
            WindowController.getDijkstraGridPanel().setStartPointSet(true);
            // Also saves the coordinates of the start point for later use
            WindowController.setStartPointRow(panel.getRow());
            WindowController.setStartPointColumn(panel.getColumn());
            // Updates the instruction label
            WindowController.getDijkstraControlPanel().setText("Perfect! Now set the end point.");
            return;
        }

        // Sets the end point if the end point has not been set yet (set after start point)
        if (!WindowController.getDijkstraGridPanel().isEndPointSet()){
            panel.setBackground(new Color(255, 255, 255));
            WindowController.getDijkstraGridPanel().setEndPointSet(true);
            // Also saves the coordinates of the end point for later use
            WindowController.setEndPointRow(panel.getRow());
            WindowController.setEndPointColumn(panel.getColumn());
            // Enables start button after start and end have been set
            WindowController.getDijkstraControlPanel().enableStartButton();
            // Updates the instruction label
            WindowController.getDijkstraControlPanel().setText("Well done! Now draw some obstacles and press start if you're ready.");
        }
    }

    public void mousePressed(MouseEvent event) {
        // Triggers a global boolean variable that states if the mouse is currently being hold or not
        WindowController.getDijkstraGridPanel().setMouseIsPressed(true);
    }

    public void mouseReleased(MouseEvent event){
        WindowController.getDijkstraGridPanel().setMouseIsPressed(false);
    }

    public void mouseEntered (MouseEvent event){
        // If the mouse is drawn over a gridpanel and the mouse is being held down, the color of that panel will be changed (kinda like a drawing mode)
        // Only changes background color if the background color is still the original color
        if (panel.getBackground() == WindowController.getMainPanelColor()) {
            if (WindowController.getDijkstraGridPanel().isMouseIsPressed() && WindowController.getDijkstraGridPanel().isEndPointSet()) {
                panel.setBackground(new Color(0, 0, 255));
            }
        }
    }

}
