package model.position;

import enums.Days;

public class YardSale extends Position{
    /**
     * Creates a new Yardsale position instance
     *
     * @type Constructor
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     */

    public YardSale(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }
}
