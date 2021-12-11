package model.card.mailCards;

import model.player.Player;

/**
 * Get paid by your neighbor card
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class GetPaidByTheNeighbor extends MailCard {

    /**
     * Create a new GetPaidByTheNeighbor card
     * @param amount to receive from neighbor
     * @type Constructor
     */

    public GetPaidByTheNeighbor(int amount) {
        super(amount, "GetPaidByTheNeighbor");
    }

    /**
     * Get money from neighbor
     * @param p player holder
     * @type Transformer
     */

    @Override
    public void mailAction(Player p) {
        Player neighbor = p.getNeighbor();

    }
}
