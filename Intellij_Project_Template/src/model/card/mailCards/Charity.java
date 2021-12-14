package model.card.mailCards;

import model.player.Player;

/**
 * Pay the given amount to jackpot
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */


public class Charity extends MailCard {


    /**
     * Create a new Charity card
     * @param amount amount to be given to jackpot
     * @Postcondition A new instance of Charity is created
     */

    public Charity(int amount) {
        super(amount, "Charity");
    }

    /**
     * Deposit money to jackpot
     * @param p play holder
     * @type Transformer
     * @Precondition Player p is not null
     * @Postcondition Jackpot amount is increased
     */

    @Override
    public void action(Player p) {

    }
}
