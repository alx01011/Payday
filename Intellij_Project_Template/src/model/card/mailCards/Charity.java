package model.card.mailCards;

import model.player.Player;

import java.net.URL;

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

    public Charity(int amount, String text, String acceptText, String imageURL) {
        super(amount, text, acceptText,imageURL);
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
        int amount = super.getValue();
        int balance = p.getBank_balance();

        if (balance - amount < 0) {
            int loan = (amount - balance) + ((amount - balance) % 1000);
            p.setBank_balance(p.getBank_balance() + loan);
            p.setLoans(p.getLoans() + loan);
        }

    }
}
