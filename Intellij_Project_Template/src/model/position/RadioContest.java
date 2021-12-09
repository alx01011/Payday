package model.position;

import enums.Days;

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
}
