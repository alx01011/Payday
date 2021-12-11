package model.card.dealCards;

import model.card.Card;
import model.player.Player;

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

    /**
     * Returns the deal cards price offer
     * @return price offer
     */

    @Override
    public int getValue() {
        return BuyPrice;
    }

    /**
     * Returns the sell price of the offer
     * @return sell price
     */

    public int getSellPrice()
    {
        return sellPrice;
    }

    /**
     * Accept or decline the deal
     * @param p player - deal holder
     */

    public void dealAction(Player p)
    {
        // accept or decline the deal
    }

}
