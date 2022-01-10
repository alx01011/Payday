package model.position;

import enums.Days;
import model.player.Player;

import java.net.URL;

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
     * @Precondition day and URL are not null and index is positive or zero
     * @Postcondition A new instance of buyer is created
     */
    public Buyer(Days day, URL imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Sell one of the products previously bought with a deal card
     * @param p player seller
     * @type Transformer
     * @Precondition p is not null
     * @Postcondition A product may be sold
     */

    @Override
    public void posAction(Player p) {

    }
}
