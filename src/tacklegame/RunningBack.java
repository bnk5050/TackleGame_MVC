/*
The Runningback class is a subclass of the player class
It has s different clolor and handles movement differently
 */
package tacklegame;

import java.awt.Point;
import java.awt.event.KeyEvent;

public class RunningBack extends Player {
    
    //empty constructor
    
    public RunningBack(){
        super();
    }
    
    //main constructor used by the field class
    
    public RunningBack(Point startLoc, int newSpeed){
        super(startLoc, newSpeed);

    }
    
    //Method to move the runningback based on the location of the enzones and sidelines
    
    void moveRunningback(KeyEvent e, Endzone leftEndzone, Sideline topSideline, Sideline bottomSideline) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            //System.out.println("Left");
            this.moveLeft();
                        if (this.getBounds().intersects(leftEndzone.getBounds()))
                this.moveRight();
            }
        
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            //System.out.println("Right");
            this.moveRight();
            }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            //System.out.println("Up");
            this.moveUp();
            if (this.getBounds().intersects(topSideline.getBounds()))
                this.moveDown();
            }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            //System.out.println("Down");
            this.moveDown();
            if (this.getBounds().intersects(bottomSideline.getBounds()))
                this.moveUp();
            }
    }
    
}
