package model.position;

import enums.Days;
import model.player.Player;

import java.net.URL;

/**
 * Payday position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Payday extends Position
{

    /**
     * Creates a new Payday position instance
     * @param imageURL image location
     * @type Constructor
     * @Precondition imageURL is not null
     * @Postcondition A new payday position is created
     */
    public Payday(URL imageURL) {
        super(Days.Wednes, imageURL, 31); // by defaults payday is on Wednesday the 31st
    }

    /**
     * Perform all the payday actions on player p
     * @param p player
     * @type Transformer
     * @Precondition p is not null
     * @Postcondition payday actions are performed on p
     */

    @Override
    public void posAction(Player p) {
        // give money
        // pay bills
        // pay loans
        // if last round place cards on stack
        // if not last round move player on start
    }
}
