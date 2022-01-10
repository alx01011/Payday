package model.position;

import enums.Days;
import model.card.Card;
import model.card.mailCards.MailCard;
import model.player.Player;

import java.net.URL;

/**
 * Message position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Mail extends Position {

    private final int cardAmount;

    /**
     * Creates a new message position instance
     * @type Constructor
     * @param day     position day
     * @param imageURL image location
     * @param index    position on the board
     * @Precondition day and URL are not null and index is positive or zero
     * @Postcondition A new instance of Mail is created
     */
    public Mail(Days day, URL imageURL, int index, int cardAmount) {
        super(day, imageURL, index);
        this.cardAmount = cardAmount;
    }

    /**
     * Randomly give player p a mail card
     * @param p player
     * @type Transformer
     * @Precondition p is not null
     * @Postcondition p is given a mail card
     */

    @Override
    public void posAction(Player p) {
        MailCard mail; // random mail card
    }


    public int getCardAmount()
    {
        return cardAmount;
    }

}
