/*
This class holds the design of the scoreboard and has methods for updating it
 */
package tacklegame;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Scoreboard extends JPanel{
    
    private JTextField scores;
    
    //Default constructor creates a scoreboard and displays the scores
    public Scoreboard(){
        super();
        scores = new JTextField("Touchdowns: 0 Tackles: 0" );
        add(scores);
       }

    /**
     * @return the scores
     */
    public JTextField getScores() {
        return scores;
    }

    /**
     * @param scores the scores to set
     */
    public void setScores(JTextField scores) {
        this.scores = scores;
    }
    
    public void updateScores(String display){
        scores.setText(display);
    }
}