package model.card.mailCards;

import model.player.Player;

import java.net.URL;

/**
 * Get paid by your neighbor card
 *
 * @author Alexandros Antonakakis (csd4802)
 * @version 1.0
 */

public class GetPaidByTheNeighbor extends MailCard {

    /**
     * Create a new GetPaidByTheNeighbor card
     *
     * @param amount to receive from neighbor
     * @type Constructor
     * @Postcondition A new instance of GetPaidByTheNeighbor is created
     */

    public GetPaidByTheNeighbor(int amount, String text, String acceptText, String imageURL) {
        super(amount, text, acceptText, imageURL);
    }

    /**
     * Get money from neighbor
     *
     * @param p player holder
     * @type Transformer
     * @Precondition Player p is not null
     * @Postcondition Account balance increased
     */

    @Override
    public void action(Player p) {
        Player neighbor = p.getNeighbor();

        int amount = super.getValue();
        int balance = neighbor.getBank_balance();

        if (balance - amount < 0) {
            int loan = (amount - balance) + ((amount - balance) % 1000);
            neighbor.setBank_balance(neighbor.getBank_balance() + loan);
            neighbor.setLoans(neighbor.getLoans() + loan);
        }
        neighbor.setBank_balance(neighbor.getBank_balance() - amount);
        p.setBank_balance(p.getBank_balance() + amount);
    }
}
