package model.card.mailCards;

import model.player.Player;

/**
 * Pay the bank the given amount at the end of the month card
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class PayTheBill extends MailCard {

    /**
     * Create a new bill card
     * @type Constructor
     * @param amount amount to pay
     */

    public PayTheBill(int amount)
    {
        super(amount, "PayTheBill");
    }

    /**
     * Pay the bank the given amount
     * @param p player to pay
     * @type Transformer
     */

    @Override
    public void mailAction(Player p) {

    }
}
