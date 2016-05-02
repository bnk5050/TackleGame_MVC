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
            public void actionPerformed(ActionEvent ae) {
                model.moveTackles();
                checks();
                view.getFrame().getMp().getMyField().requestFocusInWindow();
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
            @Override
            public void keyPressed(KeyEvent e) {
                model.moveRunningback(e);
                checks();
            }
        });
    }

    private void updateField(){
        view.getFrame().getMp().getMyField().updatePlayers(model.getRb().getBounds(), 
                model.getT1().getBounds(), model.getT2().getBounds(), model.getT3().getBounds());
    }
    
    private void createField() {
//        view.getFrame().getMp().getMyField().add(model.getBottomSideline());
//        view.getFrame().getMp().getMyField().add(model.getTopSideline());
//        view.getFrame().getMp().getMyField().add(model.getLeftEndzone());
//        view.getFrame().getMp().getMyField().add(model.getRightEndzone());
    }

    private void addPlayers() {
//        view.getFrame().getMp().getMyField().add(model.getRb());
//        view.getFrame().getMp().getMyField().add(model.getT1());
//        view.getFrame().getMp().getMyField().add(model.getT2());
//        view.getFrame().getMp().getMyField().add(model.getT3());
    }
   
    private void checks(){
        model.checkTackle();
        model.checkTouchdown();
        updateField();
        view.getFrame().getMp().getMyScoreboard().updateScores("Touchdowns: " 
                + model.getNumTouchdowns() + 
                " Tackles: " + model.getNumTackles());
    }
    
}


