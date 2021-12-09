package model.position;

import enums.Days;

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
}
