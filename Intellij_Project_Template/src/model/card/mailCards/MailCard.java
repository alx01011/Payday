package model.card.mailCards;

import model.card.Card;
import model.player.Player;

/**
 * Mail card
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public abstract class MailCard implements Card
{
    private int amount;
    private String type;

    /**
     * Constructor for MailCard
     * @param amount mail card amount
     * @param type mail card name
     * @type Constructor
     * @Postcondition A new instance of MailCard is created
     */

    public MailCard(int amount, String type)
    {
        this.amount = amount;
        this.type = type;
    }

    /**
     * Returns the amount value of the card
     * @type Accessor
     * @return the amount due
     * @Precondition Amount is initialized
     * @Postcondition Amount is returned
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

    /**
     * Abstract action function implemented in each mail card
     * @param p player
     * @type Transformer
     * @Precondition Player p is not null
     * @Postcondition MailCard action is performed
     */

    public abstract void action(Player p);

}
