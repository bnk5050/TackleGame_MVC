/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tacklegame;

/**

 @author brian.kirby
 */
public class TView {
    
    private InitialFrame frame;

    public TView() {
        frame = new InitialFrame();
    }

    /**
     * @return the frame
     */
    public InitialFrame getFrame() {
        return frame;
    }

    /**
     * @param frame the frame to set
     */
    private void setFrame(InitialFrame frame) {
        this.frame = frame;
    }
    
    
}

