package model.card.mailCards;

import model.player.Player;

/**
 * Pay the neighbor
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class PayTheNeighbor extends MailCard {

    /**
     * Create a new PayTheNeighbor card
     * @param amount amount to pay the neighbor
     * @type Constructor
     * @Postcondition A new instance of PayTheNeighbor is created
     */

    public PayTheNeighbor(int amount) {
        super(amount, "PayTheNeighbor");
    }

    /**
     * Pay the neighbor
     * @param p player to pay the neighbor
     * @type Transformer
     * @Precondition Player p is not null
     * @Postcondition Account balance is reduced
     */

    @Override
    public void action(Player p) {
        Player neighbor = p.getNeighbor();
    }
}
