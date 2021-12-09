package model.position;

import enums.Days;

/**
 * Payday position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Payday extends Position
{

    /**
     * Creates a new Payday position instance
     *
     * @param imageURL image location
     * @type Constructor
     */
    public Payday(String imageURL) {
        super(Days.WEDNESDAY, imageURL, 31); // by defaults payday is on Wednesday the 31st
    }
}
