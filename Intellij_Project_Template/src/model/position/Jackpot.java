package model.position;

import enums.Days;

/**
 * Jackpot position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Jackpot extends Position{
    /**
     * Creates a new jackpot position instance
     *
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     * @type Constructor
     */
    public Jackpot(Days day, String imageURL, int index) {
        super(Days.NONE, imageURL, 33); // place it 2 days after payday
    }
}
