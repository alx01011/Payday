package model.position;

import enums.Days;

/**
 * Board positions
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public abstract class Position
{
    private final Days day;
    private final String imageURL;
    private final int day_index;


    /**
     * Creates a new position instance
     * @type Constructor
     * @param day position day
     * @param imageURL image location
     * @param day_index position on the board
     */

    public Position(Days day, String imageURL, int day_index)
    {
        this.day = day;
        this.imageURL = imageURL;
        this.day_index = day_index;

    }

    /**
     * Returns the position name
     * @type accessor
     * @return position name
     */

    public Days getDay() {
        return day;
    }

    /**
     * Returns image location
     * @type accessor
     * @return the images location
     */

    public String getImageURL() {
        return imageURL;
    }

    /**
     * Returns position on the board
     * @return index
     */

    public int getDay_index() {
        return day_index;
    }


}
