package model.position;

import enums.Days;
import model.player.Player;

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
     */

    public RadioContest(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Players roll dice and the highest number get 1000euros from bank
     * @param p player
     * @type Transformer
     */

    @Override
    public void posAction(Player p) {
        Player p2 = p.getNeighbor();
    }
}
