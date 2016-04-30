/*
The Control Panel class adds a slider and a text field to the control panel area of the window
The speedControl JSlider sets the speed at which the tacklers move in the game

 */
package tacklegame;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ControlPanel extends JPanel {
    
    private JSlider speedControl;
    private JTextField description;
    
    //Default constructor
    
    public ControlPanel() {
        super();
        description = new JTextField("Set the speed of the game");
        speedControl = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
        add(speedControl);
        add(description);
    }

    /**
     * @return the speedControl
     */
    public JSlider getSpeedControl() {
        return speedControl;
    }

}
