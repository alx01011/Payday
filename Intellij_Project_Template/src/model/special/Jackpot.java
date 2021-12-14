package model.special;

import model.player.Player;

/**
 * Jackpot position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Jackpot{

    private int amount; // jackpot amount


    private String imageURL;

    /**
     * Creates a new jackpot position instance
     *
     * @param imageURL image location
     * @type Constructor
     */
    public Jackpot(String imageURL) {
        this.imageURL = imageURL;
        amount = 0;
    }

    /**
     * Give the amount of money in jackpot to the player
     * @param p player
     * @type Transformer
     */

    public void posAction(Player p) {
        p.setBank_balance(p.getBank_balance() + amount);
    }

    /**
     * Get the current jackpot amount
     * @return jackpot amount
     * @type Accessor
     */

    public int getAmount() {
        return amount;
    }

    /**
     * Sets amount for jackpot
     * @param amount amount
     * @type Transformer
     */

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Returns the imageURL
     * @return imageurl
     * @type Accessor
     */

    public String getImageURL() {
        return imageURL;
    }

    /**
     * Sets the imageURL
     * @param imageURL imageurl
     * @type Transformer
     */

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}
