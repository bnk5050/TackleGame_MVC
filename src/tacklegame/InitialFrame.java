/*
This frame class is a JFrame
Static variables are used to set the window height and width
 */
package tacklegame;

import javax.swing.JFrame;


public class InitialFrame extends JFrame{
    
    private int WINDOW_HEIGHT; 
    private int WINDOW_WIDTH;
    private String GAME_TITLE;
    private InitialPanel mp;
    
    public InitialFrame (){
        super(); //Call JFame and pass game title
        this.WINDOW_WIDTH = 1000; //field is 1000px wide
        this.WINDOW_HEIGHT = 520; //field is 410px tall
        this.GAME_TITLE = "Tackle Game";
        
        mp = new InitialPanel();
        add(mp);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //Set window size to 650 x 480
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(GAME_TITLE);
        setVisible(true);
    }

    /**
     * @return the mp
     */
    public InitialPanel getMp() {
        return mp;
    }

    /**
     * @param mp the mp to set
     */
    public void setMp(InitialPanel mp) {
        this.mp = mp;
    }
    
}
