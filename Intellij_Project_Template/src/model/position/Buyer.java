package model.position;

import enums.Days;
import model.player.Player;

/**
 * Buyer position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Buyer extends Position
{

    /**
     * Creates a new buyer position instance
     * @type Constructor
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     */
    public Buyer(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Sell one of the products previously bought with a deal card
     * @param p player seller
     * @type Transformer
     */

    @Override
    public void posAction(Player p) {

    }
}
