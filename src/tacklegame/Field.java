/*


 */
package tacklegame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Field extends JPanel {

    public Field() {

        super();
        setLayout(null);
        setBackground(Color.GREEN);
        setFocusable(true);
    }
    

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        requestFocusInWindow();
        
    }
    
}

