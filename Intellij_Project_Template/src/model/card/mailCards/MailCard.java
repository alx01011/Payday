package model.card.mailCards;

import model.card.Card;

/**
 * Mail card
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

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
    public int getValue()
    {
        return amount;
    }


    /**
     * Returns a string with the card type
     * @return card type
     */

    @Override
    public String toString()
    {
        return "MailCard";
    }
}
