/*
This is the abstract player class
It defines a player as a button that has a size, number, and speed
It can move left, right, up, and down

 */
package tacklegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JButton;

public abstract class Player extends JButton{

        private int playerSize = 20;
        private String playerNumber = "1";
        private int playerSpeed = 1;
        
    public Player() {
        super("Player");
        Rectangle pos = new Rectangle(0,0, playerSize, playerSize);
        setBounds(pos);
        setBackground(Color.black);
    }
    
    public Player(Point startLoc){
        super();
        Rectangle pos = new Rectangle(startLoc, new Dimension(playerSize, playerSize));
        setBounds(pos);
        setBackground(Color.black);
    }

    public Player(Point startLoc, int newSpeed){
        super();
        Rectangle pos = new Rectangle(startLoc, new Dimension(playerSize, playerSize));
        setBounds(pos);
        setBackground(Color.black);
        playerSpeed = newSpeed;
    }    
    

    public void moveLeft(){
        setLocation((getX()- getPlayerSpeed()), (getY()));
        repaint();
    }
    
    public void moveRight(){
        setLocation((getX()+ getPlayerSpeed()), (getY()));
        repaint();
    }
    
    public void moveUp(){
        setLocation((getX()), (getY()- getPlayerSpeed()));
        repaint();
    }
    
    public void moveDown(){
        setLocation((getX()), (getY()+ getPlayerSpeed()));
        repaint();
    }
    
    public void setPos(int x, int y){
        setLocation(x, y);
        repaint();
    }
    
    /**
     * @return the playerSize
     */
    public int getPlayerSize() {
        return playerSize;
    }

    /**
     * @param playerSize the playerSize to set
     */
    public void setPlayerSize(int playerSize) {
        this.playerSize = playerSize;
        this.setSize(playerSize, playerSize);
        
    }

    /**
     * @return the playerNumber
     */
    public String getPlayerNumber() {
        return playerNumber;
    }

    /**
     * @param playerNumber the playerNumber to set
     */
    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
        this.setText(playerNumber);
    }

    /**
     * @return the playerSpeed
     */
    public int getPlayerSpeed() {
        return playerSpeed;
    }

    /**
     * @param playerSpeed the playerSpeed to set
     */
    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }
    
}
