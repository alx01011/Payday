package model.position;

import enums.Days;

/**
 * Message position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Message extends Position {

    /**
     * Creates a new message position instance
     * @type Constructor
     * @param day     position day
     * @param imageURL image location
     * @param index    position on the board
     */
    public Message(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }
}
