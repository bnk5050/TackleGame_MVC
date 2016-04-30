/*
The endzone class determines what an endzone will look like

 */
package tacklegame;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JButton;


public class Endzone extends JButton {

    public Endzone(int x, int y, int height, int width) {
        super();
        setBounds(new Rectangle(x, y, height, width));
        setBackground(Color.yellow);
        setVisible(true);
    }
    
}
