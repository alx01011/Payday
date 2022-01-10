package model.position;

import enums.Days;
import model.player.Player;

import java.net.URL;

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
     * @Precondition day and URL are not null and index is positive or zero
     * @Postcondition A new instance of YardSale is created
     */

    public YardSale(Days day, URL imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Player p rolls the dice again and pays 100 * number on dice then take the first deal card on the stack
     * @param p player
     * @type Transformer
     * @Precondition p is not null
     * @Postcondition Account balanced decreased and a new deal card is drawn
     */

    @Override
    public void posAction(Player p) {

    }
}
