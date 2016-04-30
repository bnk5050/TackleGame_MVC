/*
The sideline class determines what the sideline looks like
 */
package tacklegame;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JButton;

public class Sideline extends JButton{

    public Sideline(int x, int y, int height, int width) {
        super();
        setBounds(new Rectangle(x, y, height, width));
        setBackground(Color.WHITE);
        setVisible(true);
    }
    
    
}
