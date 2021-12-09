package model.card.messageCards;

import model.card.Card;

public class MailCard implements Card
{
    private int amount;
    private String type;

    public MailCard(int amount, String type)
    {
        this.amount = amount;
        this.type = type;
    }

    /**
     * Returns the amount value of the card
     * @type Accessor
     * @return the amount due
     */

    @Override
    public int getAmount()
    {
        return amount;
    }

    /**
     * Sets a new value for amount
     * @type Transformer
     */

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "MailCard";
    }
}
