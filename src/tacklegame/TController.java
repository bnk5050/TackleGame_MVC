/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tacklegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**

 @author brian.kirby
 */
public class TController {
    
    private TModel model;  //Declare TModel object named model
    private TView view; //Declare TView object named view
    private Timer gameTimer; //Declare Time object named gametimer 
    private int delay = 200; //Set default key press delay
    
    public TController(TModel model, TView view) { //constructor that receives a model and view
        this.model = model; //assigns received model reference to model object
        this.view = view; //assigns recieved view reference
        newMovementListener(); //calls listener methods
        newSettingsListener();     
        newButtonListener();
        
        getField().requestFocusInWindow(); //
        
        gameTimer = new Timer(delay, new ActionListener() { //instantiates a Time object named gameTimer with inner listener
            @Override
            public void actionPerformed(ActionEvent ae) {
                model.moveTackles();
                checks();
                getField().requestFocusInWindow();
            }
        });
    }
    
    
    private void newButtonListener(){
        getControlPanel().getStartButton().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if (gameTimer.isRunning()){
                    getControlPanel().changeButtonStart();
                    gameTimer.stop();
                }
                else {
                    getControlPanel().changeButtonPause();
                    gameTimer.start();
                }
                
            }
    });
    }
    private void newSettingsListener(){
        getControlPanel().getSpeedControl().addChangeListener( new ChangeListener() {
            //When the slider is changed, change the Speed of the tacklers
            @Override
            public void stateChanged(ChangeEvent ce) {
                model.changeSpeed(getControlPanel().getSpeedControl().getValue());   
            }
        });
    }

    private void newMovementListener(){
        getField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (gameTimer.isRunning()){
                    model.moveRunningback(e);
                    checks();
                }
                
            }
        });
    }

    private void updateField(){
        getField().updatePlayers(model.getRb().getBounds(), 
                model.getT1().getBounds(), model.getT2().getBounds(), model.getT3().getBounds());
    }
    
     private void checks(){
        model.checkTackle();
        model.checkTouchdown();
        updateField();
        getScoreboard().updateScores(model.getNumTouchdowns(), model.getNumTackles());
    }

     //Get View
     private ControlPanel getControlPanel(){
         return view.getFrame().getMp().getMyControlPanel();
     }
     
     private Field getField(){
         return view.getFrame().getMp().getMyField();
     }
     
     private Scoreboard getScoreboard(){
         return view.getFrame().getMp().getMyScoreboard();
     }
}


