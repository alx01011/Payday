package model.card.mailCards;

import model.card.Card;
import model.player.Player;

import java.net.URL;

/**
 * Mail card
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public abstract class MailCard implements Card
{
    private int amount;
    private String imageURL;
    private String text;
    private String acceptText;

    /**
     * Constructor for MailCard
     * @param amount mail card amount
     * @param text mail card name
     * @type Constructor
     * @Postcondition A new instance of MailCard is created
     */

    public MailCard(int amount, String text, String acceptText, String imageURL)
    {
        this.amount = amount;
        this.text = text;
        this.imageURL = imageURL;
        this.acceptText = acceptText;
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

    @Override

    public void setValue(int amount)
    {
        this.amount = amount;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAcceptText() {
        return acceptText;
    }

    public void setAcceptText(String acceptText) {
        this.acceptText = acceptText;
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
