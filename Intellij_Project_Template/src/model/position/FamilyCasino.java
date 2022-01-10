package model.position;

import enums.Days;
import model.player.Player;

import java.net.URL;

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
     * @Precondition day and URL are not null and index is positive or zero
     * @Postcondition A new instance of family casino is created
     */
    public FamilyCasino(Days day, URL imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Get money from bank if dice is even or give money to jackpot if dice is odd
     * @param p player
     * @type Transformer
     * @Precondition p is not null
     * @Postcondition Get money from bank or add to jackpot
     */

    @Override
    public void posAction(Player p) {

    }
}
