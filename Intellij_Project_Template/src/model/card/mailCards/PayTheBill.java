package model.card.mailCards;

import model.player.Player;

import java.net.URL;

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
     * @Postcondition A new instance of PayTheBill is created
     */

    public PayTheBill(int amount, String text, String acceptText, String imageURL)
    {
        super(amount, text, acceptText, imageURL);
    }

    /**
     * Pay the bank the given amount
     * @param p player to pay
     * @type Transformer
     * @Precondition  Player p is not null
     * @Postcondition Bank balance may be reduced
     */

    @Override
    public void action(Player p) {
        p.setBills(p.getBills() + super.getValue());
    }
}
