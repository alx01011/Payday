package model.position;

import enums.Days;
import model.player.Player;

import java.net.URL;

/**
 * Sweepstakes position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Sweepstakes extends Position
{

    /**
     * Creates a new Sweepstake position instance
     *
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     * @type Constructor
     * @Precondition day and URL are not null and index is positive or zero
     * @Postcondition A new instance of Sweeptakes is created
     */
    public Sweepstakes(Days day, URL imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Player p rolls dice again and receive 1000euros * number on dice
     * @param p player
     * @type Transformer
     * @Precondition p is not null
     * @Postcondition p is awarded money by dice roll
     */

    @Override
    public void posAction(Player p) {
    }
}
