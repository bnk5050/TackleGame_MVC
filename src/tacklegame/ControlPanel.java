/*
The Control Panel class adds a slider and a text field to the control panel area of the window
The speedControl JSlider sets the speed at which the tacklers move in the game

 */
package tacklegame;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ControlPanel extends JPanel {
    
    private JSlider speedControl;
    private JTextField description;
    private JButton startButton;
    
    //Default constructor
    
    public ControlPanel() {
        super();
        description = new JTextField("Set the speed of the game");
        speedControl = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
        startButton = new JButton("Start");
        add(startButton);
        add(speedControl);
        add(description);
    }

    public void changeButtonPause(){
        startButton.setText("Pause");
    }
    
    public void changeButtonStart(){
        startButton.setText("Start");
    }
    
    /**
     * @return the speedControl
     */
    public JSlider getSpeedControl() {
        return speedControl;
    }

    /**
     * @return the startButton
     */
    public JButton getStartButton() {
        return startButton;
    }

}
