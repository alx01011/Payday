package model.card.mailCards;

/**
 * Pay the neighbor
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class PayTheNeighbor extends MailCard {

    /**
     * Create a new PayTheNeighbor card
     * @param amount amount to pay the neighbor
     */

    public PayTheNeighbor(int amount) {
        super(amount, "PayTheNeighbor");
    }
}
