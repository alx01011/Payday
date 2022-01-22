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
    public int jackpot_amount;

    public final LinkedList<Card> mailCardStack;
    public final LinkedList<Card> rejectedMailCardStack;
    public final LinkedList<DealCard>  dealCardStack, rejectedDealCardStack;
    public final ArrayList<Position> positions;



    private final String[][] mailCards = new String[48][4];
    private final String[][] dealCards = new String[20][8];


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

        p1.setNeighbor(p2);
        p2.setNeighbor(p1);

        cldr = ClassLoader.getSystemClassLoader();

        positions = new ArrayList<>();
        mailCardStack = new LinkedList<>();
        dealCardStack = new LinkedList<>();
        rejectedMailCardStack = new LinkedList<>();
        rejectedDealCardStack = new LinkedList<>();




        // prompt for the months to be played

        turn = ((new Random().nextInt() % 2 + 1) == 1 ? p1 : p2 ); // randomly select the first player


        init_positions();
        readFile("resources/mailCards.csv", "Mail");
        readFile("resources/dealCards.csv", "Deal");
        init_cardStacks();
        init_board();
    }

    /**
     * Reads a path
     * @param path
     * @param type
     */

    private void readFile(String path, String type) {
        BufferedReader br = null;
        String sCurrentLine;
        try {
            String fullPath = Objects.requireNonNull(cldr.getResource(path)).getPath();
            br = new BufferedReader(new FileReader(fullPath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        int count = 0;
        try {
            br.readLine();
            while ((sCurrentLine = br.readLine()) != null) {
                if (type.equals("Mail")) {
                    mailCards[count++] = sCurrentLine.split(",");
                } else {
                    dealCards[count++] = sCurrentLine.split(",");
                }
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        for (String[] mailCard : mailCards) {
            int amount = Integer.parseInt(mailCard[4]);
            String url = mailCard[5];
            String msg = mailCard[2];
            String acceptTxt = mailCard[3];


            switch (mailCard[1]) {
                case "Αdvertisement" -> mailCardStack.add(new Advertisement(amount, msg, acceptTxt, url));
                case "Bill" -> mailCardStack.add(new PayTheBill(amount, msg, acceptTxt, url));
                case "Charity" -> mailCardStack.add(new Charity(amount, msg, acceptTxt, url));
                case "PayTheNeighbor" -> mailCardStack.add(new PayTheNeighbor(amount, msg, acceptTxt, url));
                case "MadMoney" -> mailCardStack.add(new GetPaidByTheNeighbor(amount, msg, acceptTxt, url));
                case "MoveToDealBuyer" -> mailCardStack.add(new MoveToDB(0, msg, acceptTxt, url));
                default -> throw new IllegalArgumentException("Invalid Card Type");
            }
        }

        // init deal cards

        for (String[] dealCard : dealCards)
        {
            int buy = Integer.parseInt(dealCard[3]);
            int sell = Integer.parseInt(dealCard[4]);

            String url = dealCard[5];
            String msg = dealCard[2];

            dealCardStack.add(new DealCard(buy, sell, url, msg));

        }

        // shuffle cards

        Collections.shuffle(mailCardStack);
        Collections.shuffle(dealCardStack);

    }

    public void update_balance(int amount)
    {
        int balance = turn.getBank_balance();
        if (balance - amount < 0)
        {
            int loan = (int) Math.ceil(amount - balance);
            turn.setBank_balance(turn.getBank_balance() + loan);
            turn.setLoans(turn.getLoans() + loan);
        }
        turn.setBank_balance(turn.getBank_balance() - amount);
    }

    public void nextTurn()
    {
        turn = (turn == p1 ? p2 : p1);
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

        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc1.png"), 1)); // 4 - draw1
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc1.png"),  1));
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc1.png"), 1));
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc1.png"), 1));
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc2.png"), 2)); // 4 - draw 2
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc2.png"), 2));
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc2.png"), 2));
        positions.add(new Mail(Days.NONE,cldr.getResource("resources/images/mc2.png"), 2));

        // ---------------------------------------------------------------------------------------------------------------

        // add deal positions

        positions.add(new Deal(Days.NONE, cldr.getResource("resources/images/deal.png"), 1));
        positions.add(new Deal(Days.NONE, cldr.getResource("resources/images/deal.png"), 1));
        positions.add(new Deal(Days.NONE, cldr.getResource("resources/images/deal.png"), 1));
        positions.add(new Deal(Days.NONE, cldr.getResource("resources/images/deal.png"), 1));
        positions.add(new Deal(Days.NONE, cldr.getResource("resources/images/deal.png"), 1));

        // ---------------------------------------------------------------------------------------------------------------

        // add sweepstakes positions


        positions.add(new Sweepstakes(Days.NONE, cldr.getResource("resources/images/sweep.png"), 1));
        positions.add(new Sweepstakes(Days.NONE, cldr.getResource("resources/images/sweep.png"), 1));

        // ---------------------------------------------------------------------------------------------------------------


        // add lottery positions

        positions.add(new Lottery(Days.NONE, cldr.getResource("resources/images/lottery.png"), 1));
        positions.add(new Lottery(Days.NONE, cldr.getResource("resources/images/lottery.png"), 1));
        positions.add(new Lottery(Days.NONE, cldr.getResource("resources/images/lottery.png"), 1));


        // ---------------------------------------------------------------------------------------------------------------

        // add radio contest position

        positions.add(new RadioContest(Days.NONE, cldr.getResource("resources/images/radio.png"), 1));
        positions.add(new RadioContest(Days.NONE, cldr.getResource("resources/images/radio.png"), 1));

        // ---------------------------------------------------------------------------------------------------------------

        // add buyer positions

        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), 1));
        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), 1));
        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), 1));
        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), 1));
        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), 1));
        positions.add(new Buyer(Days.NONE, cldr.getResource("resources/images/buyer.png"), 1));



        // ---------------------------------------------------------------------------------------------------------------

        // add family casino positions

        positions.add(new FamilyCasino(Days.NONE, cldr.getResource("resources/images/casino.png"), 1));
        positions.add(new FamilyCasino(Days.NONE, cldr.getResource("resources/images/casino.png"), 1));


        // ---------------------------------------------------------------------------------------------------------------

        // add yard sales position

        positions.add(new YardSale(Days.NONE, cldr.getResource("resources/images/yard.png"), 1));
        positions.add(new YardSale(Days.NONE, cldr.getResource("resources/images/yard.png"), 1));


        // ---------------------------------------------------------------------------------------------------------------


    }

    public void init_board()
    {

        Collections.shuffle(positions); // shuffle positions

        positions.get(0).setDay(Days.Monday);
        positions.get(0).setAmount(1);

        for (int i = 1; i < positions.size(); i++)
        {
            positions.get(i).setDay(Days.values()[i % 7]);
            //positions.get(i).setAmount(i + 1);
        }


        // add payday position

        positions.add(new Payday(cldr.getResource("resources/images/pay.png")));

    }

    public static void main(String[] args)
    {
        Controller ctrl = new Controller();

    }


}
