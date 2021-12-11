package model.card.mailCards;

import model.player.Player;

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
     */

    public Advertisement(int amount)
    {
        super(amount, "Advertisement");
    }


    /**
     * Sell the card
     * @param p player holder
     * @type Transformer
     */

    @Override
    public void action(Player p) {

    }
}
