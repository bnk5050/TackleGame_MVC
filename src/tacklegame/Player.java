/*
This is the abstract player class
It defines a player as a button that has a size, number, and speed
It can move left, right, up, and down

 */
package tacklegame;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Player extends Rectangle{

        private int playerSize = 20;
        private String playerNumber = "1";
        private int playerSpeed = 1;
        
    public Player() {
        super();
        Rectangle pos = new Rectangle(0,0, playerSize, playerSize);
        setBounds(pos);
    }
    
    public Player(Point startLoc){
        super();
        Rectangle pos = new Rectangle(startLoc, new Dimension(playerSize, playerSize));
        setBounds(pos);
    }

    public Player(Point startLoc, int newSpeed){
        super();
        Rectangle pos = new Rectangle(startLoc, new Dimension(playerSize, playerSize));
        setBounds(pos);
        playerSpeed = newSpeed;
    }    
    

    public void moveLeft(){
        translate(0 - (getPlayerSpeed()), 0);
    }
    
    public void moveRight(){
        translate(getPlayerSpeed(), 0);
        //setLocation((getX()+ getPlayerSpeed()), (getY()));
    }
    
    public void moveUp(){
        translate(0, (0 - getPlayerSpeed()));
        //setLocation((getX()), (getY()- getPlayerSpeed()));
    }
    
    public void moveDown(){
        translate(0, getPlayerSpeed());
        //setLocation((getX()), (getY()+ getPlayerSpeed()));
    }
    
    public void setPos(int x, int y){
        setLocation(x, y);
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
