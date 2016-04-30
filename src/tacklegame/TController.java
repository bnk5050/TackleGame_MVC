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
    
    private TModel model;
    private TView view;
    private Timer gameTimer;
    private int delay = 200;
    
    public TController(TModel model, TView view) {
        this.model = model;
        this.view = view;
        newMovementListener();
        newSettingsListener();     
        createField();
        addPlayers();
        view.getFrame().getMp().getMyField().requestFocusInWindow();
        
        gameTimer = new Timer(delay, new ActionListener() {
            @Override
            /*
            -------------------------------------
            When the timer expires, the following functions are performed:
            1. The tacklers are moved
            2. The field checks to see if a tackle has been made
            3. The field checks to see if a touchdown has been made
            -------------------------------------
            */

            public void actionPerformed(ActionEvent ae) {

                //Move the tacklers and allows them to adhere to borders and each other
                model.moveTackles();
                model.checkTackle();
                model.checkTouchdown();
                view.getFrame().getMp().getMyScoreboard().updateScores("Touchdowns: " 
                        + model.getNumTouchdowns() + 
                        " Tackles: " + model.getNumTackles());
     
            }

        });
        gameTimer.start();
    }
    
    private void newSettingsListener(){
        view.getFrame().getMp().getMyControlPanel().getSpeedControl().addChangeListener( new ChangeListener() {
            //When the slider is changed, change the Speed of the tacklers
            @Override
            public void stateChanged(ChangeEvent ce) {
                model.changeSpeed(view.getFrame().getMp().getMyControlPanel().getSpeedControl().getValue());   
            }
        });
    }

    private void newMovementListener(){
        view.getFrame().getMp().getMyField().addKeyListener(new KeyAdapter() {
            /*
            -------------------------------------
            Move the running back based on the keyPressed event
            Calls the method to move the running back, and allows the runningback
            to see the borders so it will not move through them.
             -------------------------------------
            */
            @Override
            public void keyPressed(KeyEvent e) {
                model.moveRunningback(e);
                view.getFrame().getMp().getMyField().requestFocusInWindow();
            }
        });
    }

    private void createField() {
        view.getFrame().getMp().getMyField().add(model.getBottomSideline());
        view.getFrame().getMp().getMyField().add(model.getTopSideline());
        view.getFrame().getMp().getMyField().add(model.getLeftEndzone());
        view.getFrame().getMp().getMyField().add(model.getRightEndzone());
    }

    private void addPlayers() {
        view.getFrame().getMp().getMyField().add(model.getRb());
        view.getFrame().getMp().getMyField().add(model.getT1());
        view.getFrame().getMp().getMyField().add(model.getT2());
        view.getFrame().getMp().getMyField().add(model.getT3());
    }
   
    
}


