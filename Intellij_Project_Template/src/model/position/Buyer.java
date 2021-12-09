package model.position;

import enums.Days;

/**
 * Buyer position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Buyer extends Position
{

    /**
     * Creates a new buyer position instance
     * @type Constructor
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     */
    public Buyer(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }
}
