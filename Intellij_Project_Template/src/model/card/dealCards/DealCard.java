package model.card.dealCards;

import model.card.Card;

/**
 * Deal card
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class DealCard implements Card {

    private final int BuyPrice;
    private final int sellPrice;

    /**
     * Create a new deal card instance
     * @param amount deal cards offer
     * @param original_amount original price
     */

    public DealCard(int amount, int original_amount)
    {
        this.BuyPrice = amount;
        this.sellPrice = original_amount;
    }

    @Override
    public int getValue() {
        return BuyPrice;
    }

}
