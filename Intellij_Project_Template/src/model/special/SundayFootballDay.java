package model.special;

import enums.Bet_Sports;

/**
 * SundayFootBallDay core
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class SundayFootballDay
{
    private       int bet;
    private final Bet_Sports choice;

    public SundayFootballDay(Bet_Sports choice)
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
