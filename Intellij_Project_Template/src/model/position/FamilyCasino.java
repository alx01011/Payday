package model.position;

import enums.Days;
import model.player.Player;

/**
 * Family casino position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class FamilyCasino extends Position
{

    /**
     * Creates a new family casino position instance
     *
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     * @type Constructor
     */
    public FamilyCasino(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Get money from bank if dice is even or give money to jackpot if dice is odd
     * @param p player
     * @type Transformer
     */

    @Override
    public void posAction(Player p) {

    }
}
