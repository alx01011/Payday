package model.player;

/**
 * Player
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Player
{
    private final String name;
    private       int    bank_balance; // bank account balance
    private       int    loans; // bank loans
    private       int    due; // bills
    private       int    position; // players position on the board
    private       Player opponent;

    /**
     * Create a new instance of player and initializes some values
     * @type Constructor
     * @param name players callsign
     */

    public Player(String name)
    {
        this.name           = name;
        this.bank_balance   = 3500;
        this.loans          = 0;
        this.due            = 0;
        this.position       = 0; // original position at start square

    }

    /**
     * Returns players name
     * @type accessor
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * Returns player position
     * @type accessor
     * @return position
     */

    public int getPosition() {
        return position;
    }

    /**
     * Sets a new players position
     * @type Transformer
     * @param position new players position
     */

    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Returns the bank balance
     * @type Accessor
     * @return bank balance
     */

    public int getBank_balance() {
        return bank_balance;
    }

    /**
     * Updates bank balance
     * @type Transformer
     * @param bank_balance new bank balance
     */

    public void setBank_balance(int bank_balance) {
        this.bank_balance = bank_balance;
    }

    /**
     * Returns the loan amount owed
     * @type Accessor
     * @return loan
     */

    public int getLoans() {
        return loans;
    }

    /**
     * Sets a new loan amount
     * @type Transformer
     * @param loans new loan amount
     */

    public void setLoans(int loans) {
        this.loans = loans;
    }

    /**
     * Returns the bill money owed by the player
     * @type Accessor
     * @return bill due
     */

    public int getDue() {
        return due;
    }

    /**
     * Updates the bill money owed by the player
     * @type Transformer
     * @param due new bills due
     */

    public void setDue(int due) {
        this.due = due;
    }

    /**
     * Returns the players opponent
     * @return opponent player
     */

    public Player getOpponent() {
        return opponent;
    }

    /**
     * Sets a players opponent
     * @param opponent opponent to be set
     */

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }
}
