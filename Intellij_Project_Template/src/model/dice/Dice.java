package model.dice;

import java.util.Random;

/**
 * Dice
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Dice
{
    private int value;

    /**
     * Creates a new dice instance and initializes the value to 0
     * @type Constructor
     */

    public Dice()
    {
        value = 0;
    }

    /**
     * Returns the current dice number
     * @type accessor
     * @return dice value
     */

    public int getValue() {
        return value;
    }

    /**
     * Randomly selects a number between 1 and 6 for the dice
     */

    public void rollDice()
    {
        value = ((new Random().nextInt()) % 6 + 1);
    }

}
