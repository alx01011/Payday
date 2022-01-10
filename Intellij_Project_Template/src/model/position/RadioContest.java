package model.position;

import enums.Days;
import model.player.Player;

import java.net.URL;

/**
 * RadioContest position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class RadioContest extends Position
{
    /**
     * Creates a new radio contest position instance
     *
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     * @type Constructor
     * @Precondition day and URL are not null and index is positive or zero
     * @Postcondition A new instance of RadioContest is created
     */

    public RadioContest(Days day, URL imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Players roll dice and the highest number get 1000euros from bank
     * @param p player
     * @type Transformer
     * @Precondition p is not null
     * @Postcondition lucky player awarded 1000euros
     */

    @Override
    public void posAction(Player p) {
        Player p2 = p.getNeighbor();
    }
}
