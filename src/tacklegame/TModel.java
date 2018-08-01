/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tacklegame;

import java.awt.Point;
import java.awt.event.KeyEvent;

/**

 @author brian.kirby
 */
public class TModel {
        //Jersey numbers for the players.  Runningback is the user.  Tacklers are computer.
    
        private final String RUNNINGBACK_NUMBER = "3";
        private final String TACKLE_ONE_NUMBER = "9";
        private final String TACKLE_TWO_NUMBER = "9";
        private final String TACKLE_THREE_NUMBER = "7";
        
        //Size of each player.  Larger numbers = larger players
        
        private final int RUNNINGBACK_SIZE = 20;
        private final int TACKLE_ONE_SIZE = 40;
        private final int TACKLE_TWO_SIZE = 50;
        private final int TACKLE_THREE_SIZE = 40;
        
        //Pre-determined start locations for each player
        private Point rbStart = new Point(200, 200); 
        private Point t1Start = new Point(510, 100); 
        private Point t2Start = new Point(700, 200);
        private Point t3Start = new Point(720, 330);
            
        //Default speeds for the running back and the tackles
        
        private int rbSpeed = 3;
        private int tackleSpeed = 1;
        
        //Create the endzone and sideline bounds
        
        private Endzone leftEndzone; 
        private Endzone rightEndzone; 
        private Sideline topSideline;
        private Sideline bottomSideline;
    
        //Create the runningback and tacklers
        private RunningBack rb;
        private Tackler t1;
        private Tackler t2;
        private Tackler t3;

        private Integer numTouchdowns = 0;
        private Integer numTackles = 0;

    /**
    Default Constructor for the model. 
    Creates players and the endzones and sidelines
    */
    public TModel() {
        createPlayers();
        createEndzones();
    }
    
    /**
    Creates a runningback and three tacklers
    Gives each one a number and a size
    */
    private void createPlayers(){
        
        
        rb = new RunningBack(rbStart, rbSpeed);
        t1 = new Tackler(t1Start, tackleSpeed);
        t2 = new Tackler(t2Start, tackleSpeed);
        t3 = new Tackler(t3Start, tackleSpeed);
        
        rb.setPlayerNumber(RUNNINGBACK_NUMBER);
        t1.setPlayerNumber(TACKLE_ONE_NUMBER);
        t2.setPlayerNumber(TACKLE_TWO_NUMBER);
        t3.setPlayerNumber(TACKLE_THREE_NUMBER);
        
        rb.setPlayerSize(RUNNINGBACK_SIZE);
        t1.setPlayerSize(TACKLE_ONE_SIZE);
        t2.setPlayerSize(TACKLE_TWO_SIZE);
        t3.setPlayerSize(TACKLE_THREE_SIZE);

    }
    
    /**
    Creates the endzones based on x,y
    */
    private void createEndzones(){
        setLeftEndzone(new Endzone(44, 0, 75, 410)); 
        setRightEndzone(new Endzone(880, 0, 75, 410)); 
        setTopSideline(new Sideline(0, 0, 1000, 2));
        setBottomSideline(new Sideline(0, 408, 1000, 2));
    }
    
    /**
    Sets the speed of the tacklers
    @param newSpeed Integer
    */
    public void changeSpeed(int newSpeed){
        t1.setPlayerSpeed(newSpeed);
        t2.setPlayerSpeed(newSpeed);
        t3.setPlayerSpeed(newSpeed);
    }
    

    /**
     * Checks to see if a tackle has been made and handles the logic
     */
    public void checkTackle(){
        //System.out.println("Checking for tackles");
        if (rb.getBounds().intersects(t1.getBounds()) | 
                rb.getBounds().intersects(t2.getBounds()) |
                rb.getBounds().intersects(t3.getBounds())){
            setNumTackles((Integer) (getNumTackles() + 1));
            resetField();
        }

    }
    
    /**
     Checks for a touchdown and handles the logic when a touchdown is made
    */    
    public void checkTouchdown(){
        //System.out.println("Checking for touchdowns");
        if (rb.getBounds().intersects(rightEndzone.getBounds())){
            setNumTouchdowns((Integer) (getNumTouchdowns() + 1));
            resetField();
        }
        
    }
    /**
    Resets the field based on the starting locations
    */
    public void resetField(){
        rb.setLocation(rbStart);
        t1.setLocation(t1Start);
        t2.setLocation(t2Start);
        t3.setLocation(t3Start);
    }
    
    /**
    Moves the tackles
    */
    public void moveTackles(){
        t1.moveTackle(rb, leftEndzone, rightEndzone, topSideline, bottomSideline, t2, t3);
        t2.moveTackle(rb, leftEndzone, rightEndzone, topSideline, bottomSideline, t1, t3);
        t3.moveTackle(rb, leftEndzone, rightEndzone, topSideline, bottomSideline, t1, t2);
    }

    /**
    Moves the runningback
    @param e a KeyEvent object
    */
    public void moveRunningback (KeyEvent e){
        rb.moveRunningback(e, leftEndzone, topSideline, bottomSideline);
    }
    
    
/*
    ===========================================================================
    GETTERS AND SETTERS
    ===========================================================================
*/
    /**
     * @return the rb
     */
    public RunningBack getRb() {
        return rb;
    }

    /**
     * @param rb the rb to set
     */
    private void setRb(RunningBack rb) {
        this.rb = rb;
    }

    /**
     * @return the t1
     */
    public Tackler getT1() {
        return t1;
    }

    /**
     * @param t1 the t1 to set
     */
    private void setT1(Tackler t1) {
        this.t1 = t1;
    }

    /**
     * @return the t2
     */
    public Tackler getT2() {
        return t2;
    }

    /**
     * @param t2 the t2 to set
     */
    private void setT2(Tackler t2) {
        this.t2 = t2;
    }

    /**
     * @return the t3
     */
    public Tackler getT3() {
        return t3;
    }

    /**
     * @param t3 the t3 to set
     */
    private void setT3(Tackler t3) {
        this.t3 = t3;
    }

    /**
     * @return the leftEndzone
     */
    public Endzone getLeftEndzone() {
        return leftEndzone;
    }

    /**
     * @param leftEndzone the leftEndzone to set
     */
    private void setLeftEndzone(Endzone leftEndzone) {
        this.leftEndzone = leftEndzone;
    }

    /**
     * @return the rightEndzone
     */
    public Endzone getRightEndzone() {
        return rightEndzone;
    }

    /**
     * @param rightEndzone the rightEndzone to set
     */
    private void setRightEndzone(Endzone rightEndzone) {
        this.rightEndzone = rightEndzone;
    }

    /**
     * @return the topSideline
     */
    public Sideline getTopSideline() {
        return topSideline;
    }

    /**
     * @param topSideline the topSideline to set
     */
    private void setTopSideline(Sideline topSideline) {
        this.topSideline = topSideline;
    }

    /**
     * @return the bottomSideline
     */
    public Sideline getBottomSideline() {
        return bottomSideline;
    }

    /**
     * @param bottomSideline the bottomSideline to set
     */
    private void setBottomSideline(Sideline bottomSideline) {
        this.bottomSideline = bottomSideline;
    }

    /**
     * @return the numTouchdowns
     */
    public Integer getNumTouchdowns() {
        return numTouchdowns;
    }

    /**
     * @param numTouchdowns the numTouchdowns to set
     */
    private void setNumTouchdowns(Integer numTouchdowns) {
        this.numTouchdowns = numTouchdowns;
    }

    /**
     * @return the numTackles
     */
    public Integer getNumTackles() {
        return numTackles;
    }

    /**
     * @param numTackles the numTackles to set
     */
    private void setNumTackles(Integer numTackles) {
        this.numTackles = numTackles;
    }
}
