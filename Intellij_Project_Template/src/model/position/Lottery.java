package model.position;

import enums.Days;
import model.player.Player;

/**
 * Lottery position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Lottery extends Position{
    /**
     * Creates a new lottery position instance
     *
     * @type Constructor
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     * @Precondition day and URL are not null and index is positive or zero
     * @Postcondition A new instance of lottery is created
     */
    public Lottery(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Let both players select a random then shuffle and reward the winner
     * @param p player
     * @type Transformer
     * @Precondition p is not null
     * @Postcondition Winner is rewarded
     */

    @Override
    public void posAction(Player p) {
        Player p2 = p.getNeighbor();

        // select numbers and shuffle

    }
}
