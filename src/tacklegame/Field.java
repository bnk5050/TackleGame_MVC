/*


 */
package tacklegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Field extends JPanel {

    private Rectangle rbRectangle;
    private Rectangle t1Rectangle;
    private Rectangle t2Rectangle;
    private Rectangle t3Rectangle;
    
    private final ImageIcon fieldImage = new ImageIcon("images/FieldImage1000x410.png");
            
    public Field() {
        super();
        setLayout(null);
        setBackground(Color.GREEN);
        setFocusable(true);
        
        rbRectangle = new Rectangle();
        t1Rectangle = new Rectangle();
        t2Rectangle = new Rectangle();
        t3Rectangle = new Rectangle();
        //Image fieldImage = Toolkit.getDefaultToolkit().getImage("");
        
        
    }

    public void updatePlayers (Rectangle rb, Rectangle t1, 
        Rectangle t2, Rectangle t3){ 
        rbRectangle = rb;
        t1Rectangle = t1;
        t2Rectangle = t2;
        t3Rectangle = t3;
        repaint();
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fieldImage.getImage(), 0, 0, this);
        g.setColor(Color.BLUE);
        g.fillRect(rbRectangle.x, rbRectangle.y, rbRectangle.width, rbRectangle.height);
        g.setColor(Color.red);
        g.fillRect(t1Rectangle.x, t1Rectangle.y, t1Rectangle.width, t1Rectangle.height);
        g.fillRect(t2Rectangle.x, t2Rectangle.y, t2Rectangle.width, t2Rectangle.height);
        g.fillRect(t3Rectangle.x, t3Rectangle.y, t3Rectangle.width, t3Rectangle.height);
        requestFocusInWindow();
    }
    
}

