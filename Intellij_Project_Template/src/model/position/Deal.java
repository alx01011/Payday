package model.position;

import enums.Days;

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
