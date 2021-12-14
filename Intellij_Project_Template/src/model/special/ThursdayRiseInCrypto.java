package model.special;


import enums.Bet_Crypto;
import model.dice.Dice;

/**
 * ThursdayRiseInCrypto core
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class ThursdayRiseInCrypto {

    private final Bet_Crypto choice;
    private       Dice newRoll;

    /**
     * Constructor
     * @param choice bet/no_bet
     * @type Constructor
     * @Postcondition A new object is created
     */

    public ThursdayRiseInCrypto(Bet_Crypto choice)
    {
        this.choice = choice;
    }


}
