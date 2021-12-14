package model.special;

import enums.Bet;

/**
 * SundayFootBallDay core
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class SundayFootballDay
{
    private       int bet;
    private final Bet choice;

    public SundayFootballDay(Bet choice)
    {
        this.choice = choice;
    }


    /**
     * Depending on the users choice place a bet or not
     * @type Transformer
     * @Precondition A SundayFootballDay is instantiated and choice is initialized
     * @Postcondition A bet may be placed
     */

    public void action()
    {
        switch(choice)
        {
        }
    }



}
