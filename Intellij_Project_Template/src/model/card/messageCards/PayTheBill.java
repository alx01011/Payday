package model.card.messageCards;

/**
 * Pay the bank the given amount at the end of the month card
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class PayTheBill extends MessageCard{

    /**
     * Create a new bill card
     * @type Constructor
     * @param amount amount to pay
     */

    public PayTheBill(int amount)
    {
        super(amount, "PayTheBill");
    }

}
