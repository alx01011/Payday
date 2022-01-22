package model.player;

import model.card.Card;
import model.card.dealCards.DealCard;
import model.dice.Dice;

import java.util.LinkedList;

/**
 * Player
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Player
{
    private       String name;
    private       int    bank_balance; // bank account balance
    private       int    loans; // bank loans
    private       int    bills; // bills
    private       int    position; // players position on the board
    private       Player neighbor;
    private final Dice   dice;

    public final LinkedList<Card> mailCards;
    public final LinkedList<DealCard> dealCards;

    /**
     * Create a new instance of player and initializes some values
     * @type Constructor
     * @param name players callsign
     * @Precondition name is not null or of zero length
     * @Postcondition A new instance of Player is created
     */

    public Player(String name)
    {
        this.name           = name;
        this.bank_balance   = 3500;
        this.loans          = 0;
        this.bills = 0;
        this.position       = 0; // original position at start square
        this.dice           = new Dice();

        dealCards = new LinkedList<>();
        mailCards = new LinkedList<>();
    }

    /**
     * Sets a players name
     * @param name players name
     * @Precondition name is not null
     * @Postcondition player name is changed
     */

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns players name
     * @type accessor
     * @return name
     * @Precondition Name is initialized
     * @Postcondition Players name is returned
     */

    public String getName() {
        return name;
    }

    /**
     * Returns player position
     * @type accessor
     * @return position
     * @Precondition Position is not empty
     * @Postcondition Position is returned
     */

    public int getPosition() {
        return position;
    }

    /**
     * Sets a new players position
     * @type Transformer
     * @param position new players position
     * @Precondition position is positive
     * @Postcondition New position is set
     */

    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Returns the bank balance
     * @type Accessor
     * @return bank balance
     * @Precondition Bank_balance was initialized
     * @Postcondition Bank_balance is returned
     */

    public int getBank_balance() {
        return bank_balance;
    }

    /**
     * Updates bank balance
     * @type Transformer
     * @param bank_balance new bank balance
     * @Precondition bank_balance doesn't overflow int
     * @Postcondition A new balance is set
     */

    public void setBank_balance(int bank_balance) {
        this.bank_balance = bank_balance;
    }

    /**
     * Returns the loan amount owed
     * @type Accessor
     * @return loan
     * @Precondition Loan was initialized
     * @Postcondition Loan is returned
     */

    public int getLoans() {
        return loans;
    }

    /**
     * Sets a new loan amount
     * @type Transformer
     * @param loans new loan amount
     * @Precondition loans doesn't overflow int
     * @Postcondition Loans is updated
     */

    public void setLoans(int loans) {
        this.loans = loans;
    }

    /**
     * Returns the bill money owed by the player
     * @type Accessor
     * @return bill due
     */

    public int getBills() {
        return bills;
    }

    /**
     * Updates the bill money owed by the player
     * @type Transformer
     * @param bills new bills due
     * @Precondition Due field initialized
     * @Postcondition Due is returned
     */

    public void setBills(int bills) {
        this.bills = bills;
    }

    /**
     * Returns the players opponent
     * @type Accessor
     * @return opponent player
     * @Precondition Neighbor field initialized
     * @Postcondition Neighbor is returned
     */

    public Player getNeighbor() {
        return neighbor;
    }

    /**
     * Sets a players opponent
     * @param neighbor opponent to be set
     * @type Transformer
     * @Precondition neighbor is not null
     * @Postcondition A new neighbor is set
     */

    public void setNeighbor(Player neighbor) {
        this.neighbor = neighbor;
    }

    /**
     * Players dice
     * @type Accessor
     * @return dice
     * @Precondition Dice was initialized
     * @Postcondition Dice is returned
     */

    public Dice getDice() {
        return dice;
    }
}
