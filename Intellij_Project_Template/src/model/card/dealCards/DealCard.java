package model.card.dealCards;

import model.card.Card;
import model.player.Player;

/**
 * Deal card
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class DealCard implements Card {

    private  int BuyPrice;
    private  int sellPrice;
    private String imageURL;
    private String text;

    /**
     * Create a new deal card instance
     * @param amount deal cards offer
     * @param original_amount original price
     * @type Constructor
     * @Postcondition A new object is instantiated and fields are initialized
     */

    public DealCard(int amount, int original_amount, String imageURL, String text)
    {
        this.BuyPrice = amount;
        this.sellPrice = original_amount;
        this.imageURL = imageURL;
        this.text = text;
    }

    /**
     * Returns the deal cards price offer
     * @type Accessor
     * @return price offer
     * @Precondition Object is instantiated and BuyPrice field initialized
     */

    @Override
    public int getValue() {
        return BuyPrice;
    }

    @Override
    public void setValue(int value) {
        BuyPrice = value;
    }

    /**
     * Returns the sell price of the offer
     * @type Accessor
     * @return sell price
     * @Precondition Object is instantiated and sellPrice field initialized
     */

    public int getSellPrice()
    {
        return sellPrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getText() {
        return text;
    }

    /**
     * Accept or decline the deal
     * @param p player - deal holder
     * @type Transformer
     * @Precondition Player p is not null
     * @Postcondition Player accepted or declined offer
     */

    public void action(Player p)
    {
        // accept or decline the deal
    }

    @Override
    public String toString()
    {
        return "Deal " + getText() + " Buy price : " + getValue() + " Sell price : " + getSellPrice() + " image : " + getImageURL();
    }

}
