package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.WindowController;

import java.awt.Insets;
import java.awt.event.*;

public class DijkstraControlPanel extends JPanel {

    private JButton startButton;
    private JButton resetButton;
    private JLabel instructionLabel;
    

    public DijkstraControlPanel(int width, int height) {
            
        setSize(width, height);
        setLayout(new GridBagLayout());

        // Initialize components
        startButton = new JButton("Start");
        resetButton = new JButton("Reset");
        instructionLabel = new JLabel("Welcome! Please choose a start point.");


        // Component settings
        startButton.setEnabled(false);

        // Listeners
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                // Releases all the resources of the old window
                WindowController.getDijkstraMainPanel().dispose();
                // Simply restarts the whole program instead of cleaning the screen
                // Might wanna implement a screen clearing later on, but this is simply the easier and resource-problem-dodging way right now
                WindowController.startProgram();
            }
        });

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                WindowController.getDijkstraGridPanel().startDijkstra();
            }
        });

        // GridBagLayout
        // StartButton
        GridBagConstraints cStart = new GridBagConstraints();
        cStart.gridx = 0;
        cStart.gridy = 0;
        cStart.weightx = 0;
        cStart.weighty = 0;
        cStart.insets = new Insets(5, 5, 5, 5);
        cStart.ipadx = 20;
        cStart.ipady = 20;
        cStart.fill = GridBagConstraints.BOTH;
        add(startButton, cStart);

        // ResetButton
        GridBagConstraints cReset = new GridBagConstraints();
        cReset.gridx = 4;
        cReset.gridy = 0;
        cReset.weightx = 0;
        cReset.weighty = 0;
        cReset.insets = new Insets(5, 5, 5, 5);
        cReset.ipadx = 20;
        cReset.ipady = 20;
        cReset.fill = GridBagConstraints.BOTH;
        add(resetButton, cReset);

        // InstructionLabel
        GridBagConstraints cInstr = new GridBagConstraints();
        cInstr.gridx = 2;
        cInstr.gridy = 0;
        cInstr.weightx = 0;
        cInstr.weighty = 0;
        cInstr.fill = GridBagConstraints.BOTH;
        add(instructionLabel, cInstr);

        // Blank Spaces
        GridBagConstraints cBlank = new GridBagConstraints();
        cBlank.fill = GridBagConstraints.BOTH;
        cBlank.gridx = 1;
        cBlank.gridy = 0;
        cBlank.weightx = 0.5;
        cBlank.weighty = 0.5;
        add(new JPanel(), cBlank);
        cBlank.gridx = 3;
        add(new JPanel(), cBlank);

        setVisible(true);

    }
    
    public void enableStartButton() {
        startButton.setEnabled(true);
    }

    public void setText(String text){
        instructionLabel.setText(text);
    }
    

}
