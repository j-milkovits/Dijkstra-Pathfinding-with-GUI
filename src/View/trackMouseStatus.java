package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import Controller.WindowController;

public class trackMouseStatus extends MouseAdapter{

    // Only added this Listener so you can start dragging your mouse of the matrix (on the sides of it)

    public void mousePressed(MouseEvent event) {
        WindowController.getDijkstraGridPanel().setMouseIsPressed(true);
    }

    public void mouseReleased(MouseEvent event){
        WindowController.getDijkstraGridPanel().setMouseIsPressed(false);
    }

}
