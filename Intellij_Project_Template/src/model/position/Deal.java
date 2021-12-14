package model.position;

import enums.Days;
import model.player.Player;

/**
 * Deal position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Deal extends Position{

    /**
     * Creates a new Deal position instance
     * @type Constructor
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     * @Precondition day and URL are not null and index is positive or zero
     * @Postcondition A new instance of deal is created
     */


    public Deal(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Draw a deal card
     * @param p player
     * @type Transformer
     * @Precondition p is not null
     * @Postcondition Draw a new deal card
     */

    @Override
    public void posAction(Player p) {

    }
}
