package model.position;

import enums.Days;
import model.player.Player;

/**
 * Jackpot position
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Jackpot extends Position{

    private int amount; // jackpot amount

    /**
     * Creates a new jackpot position instance
     *
     * @param day      position day
     * @param imageURL image location
     * @param index    position on the board
     * @type Constructor
     */
    public Jackpot(Days day, String imageURL, int index) {
        super(Days.NONE, imageURL, 33); // place it 2 days after payday
        amount = 0;
    }

    /**
     * Give the amount of money in jackpot to the player
     * @param p player
     * @type Transformer
     */

    @Override
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

}
