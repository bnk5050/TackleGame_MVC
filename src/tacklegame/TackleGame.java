/*
Tackle Game v.1.5
Use the arrow keys to move the running back into the opponent's endzone, while 
avoiding being tackled.

Changelog
4/17: Added inner listeners and removed empty methods, removed static from variables
that were not used as static variables. 


 */
package tacklegame;

/**

 @author brian.kirby
 */
public class TackleGame {

    public static void main(String[] args) {
        TModel TackleModel = new TModel();
        TView TackleView = new TView();
        TController TackleController = new TController(TackleModel, TackleView); //give controller access to model and view
        

    }
    
}
