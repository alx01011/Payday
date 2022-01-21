package model.card.mailCards;

import model.player.Player;

import java.net.URL;

/**
 * Move to the next Deal/Buyer square
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class MoveToDB extends MailCard {

    /**
     * Create a new move to Deal/Buyer card
     * @type Constructor
     * @Postcondition A new instance of MoveToDB is created
     */

    public MoveToDB(int amount, String text, String acceptText, String imageURL) {
        super(0, text, acceptText,imageURL);
    }

    /**
     * Moves player p to the next DB position
     * @param p player to be moved
     * @type Transformer
     * @Precondition Player p is not null
     * @Postcondition Player p is moved to the nearest DB position
     */

    @Override
    public void action(Player p) {

    }
}
