package model.position;

import enums.Days;

public class Lottery extends Position{
    /**
     * Creates a new lottery position instance
     *
     * @type Constructor
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     */
    public Lottery(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }
}
