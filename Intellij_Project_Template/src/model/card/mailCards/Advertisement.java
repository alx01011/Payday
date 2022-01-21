package model.card.mailCards;

import model.player.Player;

import java.net.URL;

/**
 * Sell the ad card for the given amount
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Advertisement extends MailCard
{
    /**
     * Create a new advertisement card
     * @type Constructor
     * @param amount amount to sell for
     * @Postcondition A new instance of Advertisement is created
     */

    public Advertisement(int amount, String text, String acceptText, String imageURL)
    {
        super(amount, text, acceptText,imageURL);
    }


    /**
     * Sell the card
     * @param p player holder
     * @type Transformer
     * @Precondition Player p is not null
     * @Postcondition Player sells the card
     */

    @Override
    public void action(Player p) {

    }
}
