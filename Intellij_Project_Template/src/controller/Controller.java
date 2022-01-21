package controller;

import enums.Days;
import model.card.Card;
import model.card.dealCards.DealCard;
import model.card.mailCards.*;
import model.player.Player;
import model.position.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class Controller
{
    public Player p1; // 2 players
    public Player p2;
    public Player turn;
    public int months_left;
    public final LinkedList<Card> mailCardStack, dealCardStack;
    public final LinkedList<Card> rejectedMailCardStack, rejectedDealCardStack;
    public final ArrayList<Position> positions;

    LinkedList<String[][]> s;

    ClassLoader cldr;


    /**
     * Creates a new instance of Controller and initializes the board and card stacks
     * @type Constructor
     * @Postcondition A new controller is created and the fields are initialized
     */

    public Controller()
    {
        p1 = new Player("PLAYER 1");
        p2 = new Player("PLAYER 2");

        cldr = ClassLoader.getSystemClassLoader();

        positions = new ArrayList<>();
        mailCardStack = new LinkedList<>();
        dealCardStack = new LinkedList<>();
        rejectedMailCardStack = new LinkedList<>();
        rejectedDealCardStack = new LinkedList<>();


        // prompt for the months to be played

        turn = ((new Random().nextInt() % 2 + 1) == 1 ? p1 : p2 ); // randomly select the first player


        init_positions();
        init_cardStacks();
        init_board();
    }



    /**
     * Initializes the card stacks
     * @type Transformer
     * @Precondition Fields are initialized by the constructor
     * @Postcondition Card stack are initialized
     */

    private void init_cardStacks()
    {
        // init mail cards

        for (int i = 0; i < 8; i++)
        {
            mailCardStack.add(new PayTheNeighbor(0)); // amounts to be later determined
            mailCardStack.add(new GetPaidByTheNeighbor(0));
            mailCardStack.add(new Charity(0));
            mailCardStack.add(new PayTheBill(0));
            mailCardStack.add(new MoveToDB());
            mailCardStack.add(new Advertisement(0));
        }

        // init deal cards

        for (int i = 0; i < 20; i++)
        {
            dealCardStack.add(new DealCard(0, 0)); // amounts to be determined by the card
        }
    }

    /**
     * Initializes the positions
     * @type Transformer
     * @Precondition Fields are initialized by the constructor
     * @Postcondition Board positions are initialized
     */

    private void init_positions()
    {
        // add all the possible positions on the arraylist


        // add mail positions

        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc1.png"), -1, 1)); // 4 - draw1
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc1.png"), -1, 1));
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc1.png"), -1, 1));
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc1.png"), -1, 1));
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc2.png"), -1, 2)); // 4 - draw 2
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc2.png"), -1, 2));
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc2.png"), -1, 2));
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc2.png"), -1, 2));

        // ---------------------------------------------------------------------------------------------------------------

        // add deal positions

        positions.add(new Deal(Days.NONE, cldr.getResource("resources/images/deal.png"), -1));
        positions.add(new Deal(Days.NONE, cldr.getResource("resources/images/deal.png"), -1));
        positions.add(new Deal(Days.NONE, cldr.getResource("resources/images/deal.png"), -1));
        positions.add(new Deal(Days.NONE, cldr.getResource("resources/images/deal.png"), -1));
        positions.add(new Deal(Days.NONE, cldr.getResource("resources/images/deal.png"), -1));

        // ---------------------------------------------------------------------------------------------------------------

        // add sweepstakes positions


        positions.add(new Sweepstakes(Days.NONE, cldr.getResource("resources/images/sweep.png"), -1));
        positions.add(new Sweepstakes(Days.NONE, cldr.getResource("resources/images/sweep.png"), -1));

        // ---------------------------------------------------------------------------------------------------------------


        // add lottery positions

        positions.add(new Lottery(Days.NONE, cldr.getResource("resources/images/lottery.png"), -1));
        positions.add(new Lottery(Days.NONE, cldr.getResource("resources/images/lottery.png"), -1));
        positions.add(new Lottery(Days.NONE, cldr.getResource("resources/images/lottery.png"), -1));


        // ---------------------------------------------------------------------------------------------------------------

        // add radio contest position

        positions.add(new RadioContest(Days.NONE, cldr.getResource("resources/images/radio.png"), -1));
        positions.add(new RadioContest(Days.NONE, cldr.getResource("resources/images/radio.png"), -1));

        // ---------------------------------------------------------------------------------------------------------------

        // add buyer positions

        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), -1));
        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), -1));
        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), -1));
        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), -1));
        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), -1));
        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), -1));



        // ---------------------------------------------------------------------------------------------------------------

        // add family casino positions

        positions.add(new FamilyCasino(Days.NONE, cldr.getResource("resources/images/casino.png"), -1));
        positions.add(new FamilyCasino(Days.NONE, cldr.getResource("resources/images/casino.png"), -1));


        // ---------------------------------------------------------------------------------------------------------------

        // add yard sales position

        positions.add(new YardSale(Days.NONE, cldr.getResource("resources/images/yard.png"), -1));
        positions.add(new YardSale(Days.NONE, cldr.getResource("resources/images/yard.png"), -1));


        // ---------------------------------------------------------------------------------------------------------------


    }

    public void init_board()
    {

        Collections.shuffle(positions); // shuffle positions

        positions.get(0).setDay(Days.Monday);
        positions.get(0).setDay_index(1);

        for (int i = 1; i < positions.size(); i++)
        {
            positions.get(i).setDay(Days.values()[i % 7]);
            positions.get(i).setDay_index(i + 1);
        }


        // add payday position

        positions.add(new Payday(cldr.getResource("resources/images/pay.png")));

    }

    public static void main(String[] args)
    {
        Controller ctrl = new Controller();

        ctrl.init_board();

    }


}
