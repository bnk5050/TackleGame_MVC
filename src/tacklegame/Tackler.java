/*
The Tackler class is a subclass of the player abstract class
It handles movement differently than the runningback and has a different color
 */
package tacklegame;

import java.awt.Point;

public class Tackler extends Player{
    
    //default constructor
    public Tackler(){
        super();
    }
    
    //Constructor used by the field class
    
    public Tackler(Point startLoc, int tackleSpeed) {
        super(startLoc, tackleSpeed);
        
    }
    
    //Moves the tackler based on the location of the other tacklers and the endzone and sidelines
    
    public void moveTackle(RunningBack rb, Endzone leftEndzone, Endzone rightEndzone, Sideline topSideline, Sideline bottomSideline, Tackler tacklerOne, Tackler tacklerTwo) {
        Point rbLocation = new Point(rb.getLocation());
        if (rbLocation.getY() > this.getY()){
            this.moveDown();
            if (this.getBounds().intersects(bottomSideline.getBounds()) |
                    this.getBounds().intersects(tacklerOne.getBounds()) |
                    this.getBounds().intersects(tacklerTwo.getBounds()))
                this.moveUp();
        }
            
        if (rbLocation.getY() < this.getY()){
            this.moveUp();
            if (this.getBounds().intersects(topSideline.getBounds())|
                    this.getBounds().intersects(tacklerOne.getBounds()) |
                    this.getBounds().intersects(tacklerTwo.getBounds()))
                    this.moveDown();
        }
            
        if (rbLocation.getX() > this.getX()){
            this.moveRight();
            if (this.getBounds().intersects(rightEndzone.getBounds())|
                    this.getBounds().intersects(tacklerOne.getBounds()) |
                    this.getBounds().intersects(tacklerTwo.getBounds()))
                    this.moveLeft();
        }
            
        if (rbLocation.getX() < this.getX()){
            this.moveLeft();
            if (this.getBounds().intersects(leftEndzone.getBounds())|
                    this.getBounds().intersects(tacklerOne.getBounds()) |
                    this.getBounds().intersects(tacklerTwo.getBounds()))
                    this.moveRight();
        }
    }
    
}
