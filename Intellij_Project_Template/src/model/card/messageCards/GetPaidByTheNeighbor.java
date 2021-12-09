package model.card.messageCards;

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
}
