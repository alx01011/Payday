package model.position;

import enums.Days;

/**
 * Deal position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Deal extends Position{

    /**
     * Creates a new Deal position instance
     * @type Constructor
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     */
    public Deal(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }
}
