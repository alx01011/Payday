package model.position;

import enums.Days;
import model.player.Player;

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
     */
    public Sweepstakes(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Player p rolls dice again and receive 1000euros * number on dice
     * @param p player
     * @type Transformer
     */

    @Override
    public void posAction(Player p) {
    }
}
