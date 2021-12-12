package model.position;

import enums.Days;
import model.player.Player;

/**
 * YardSale position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class YardSale extends Position{
    /**
     * Creates a new Yard sale position instance
     *
     * @type Constructor
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     */

    public YardSale(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Player p rolls the dice again and pays 100 * number on dice then take the first deal card on the stack
     * @param p player
     * @type Transformer
     */

    @Override
    public void posAction(Player p) {

    }
}
