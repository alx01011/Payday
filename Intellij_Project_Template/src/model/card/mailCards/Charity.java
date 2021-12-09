package model.card.mailCards;

/**
 * Pay the given amount to jackpot
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */


public class Charity extends MailCard {


    /**
     * Create a new Charity card
     * @param amount amount to be given to jackpot
     */

    public Charity(int amount) {
        super(amount, "Charity");
    }
}
