/*
This class is a JPanel and sets up the layout for the field, scoreboard, and 
control panel
 */
package tacklegame;

import java.awt.BorderLayout;
import javax.swing.JPanel;


public class InitialPanel extends JPanel{
    
        private ControlPanel myControlPanel;
        private Scoreboard myScoreboard;
        private Field myField;
        
    public InitialPanel (){
        
        super(new BorderLayout());
        
        myControlPanel = new ControlPanel();
        myScoreboard = new Scoreboard();
        myField = new Field();
        
        add(myField, BorderLayout.CENTER);
        add(myControlPanel, BorderLayout.NORTH);
        add(myScoreboard, BorderLayout.SOUTH);
    }

    /**
     * @return the myControlPanel
     */
    public ControlPanel getMyControlPanel() {
        return myControlPanel;
    }

    /**
     * @param myControlPanel the myControlPanel to set
     */
    private void setMyControlPanel(ControlPanel myControlPanel) {
        this.myControlPanel = myControlPanel;
    }

    /**
     * @return the myScoreboard
     */
    public Scoreboard getMyScoreboard() {
        return myScoreboard;
    }

    /**
     * @param myScoreboard the myScoreboard to set
     */
    private void setMyScoreboard(Scoreboard myScoreboard) {
        this.myScoreboard = myScoreboard;
    }

    /**
     * @return the myField
     */
    public Field getMyField() {
        return myField;
    }

    /**
     * @param myField the myField to set
     */
    private void setMyField(Field myField) {
        this.myField = myField;
    }
}
