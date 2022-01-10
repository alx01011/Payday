package model.position;

import enums.Days;
import model.player.Player;

import java.net.URL;

/**
 * Board positions
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public abstract class Position
{
    private Days day;
    private int day_index;
    private final URL imageURL;


    /**
     * Creates a new position instance
     * @type Constructor
     * @param day position day
     * @param imageURL image location
     * @param day_index position on the board
     * @Precondition day and URL are not null and index is positive or zero
     * @Postcondition A new instance of Position is created
     */

        public Position(Days day, URL imageURL, int day_index)
    {
        this.day = day;
        this.imageURL = imageURL;
        this.day_index = day_index;
    }

    /**
     * Sets current day
     * @type Transformer
     * @Precondition Day is not none
     * @Postcondition day is set
     */

    public void setDay(Days day)
    {
        this.day = day;
    }

    /**
     * Returns the position name
     * @type Accessor
     * @return position name
     * @Precondition day is not null
     * @Postcondition day is returned
     */

    public Days getDay() {
        return day;
    }

    /**
     * Returns image location
     * @type Accessor
     * @return the images location
     * @Precondition imageURL is not null
     * @Postcondition imageURL is returned
     */

    public URL getImageURL() {
        return imageURL;
    }

    /**
     * Returns position on the board
     * @return index
     * @type Accessor
     * @Precondition day_index was initialized
     * @Postcondition day_index is returned
     */

    public int getDay_index() {
        return day_index;
    }

    public void setDay_index(int day_index)
    {
        this.day_index = day_index;
    }

    /**
     * Performs an action at the given position
     * @param p player
     * @type Transformer
     * @Precondition p is not null
     * @Postcondition (An) action(s) are performed
     */

    public abstract void posAction(Player p);

}
