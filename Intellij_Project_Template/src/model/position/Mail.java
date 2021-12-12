package model.position;

import enums.Days;
import model.card.Card;
import model.card.mailCards.MailCard;
import model.player.Player;

/**
 * Message position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Mail extends Position {

    /**
     * Creates a new message position instance
     * @type Constructor
     * @param day     position day
     * @param imageURL image location
     * @param index    position on the board
     */
    public Mail(Days day, String imageURL, int index) {
        super(day, imageURL, index);
    }

    /**
     * Randomly give player p a mail card
     * @param p player
     * @type Transformer
     */

    @Override
    public void posAction(Player p) {
        MailCard mail; // random mail card
    }


}
