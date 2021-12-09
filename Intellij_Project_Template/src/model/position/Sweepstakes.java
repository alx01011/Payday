package model.position;

import enums.Days;

public class Sweepstakes extends Position
{

    /**
     * Creates a new Sweepstake position instance
     *
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     * @type Constructor
     */
    public Sweepstakes(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }
}
