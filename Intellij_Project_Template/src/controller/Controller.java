package controller;

import model.card.Card;
import model.card.messageCards.MailCard;
import model.player.Player;
import model.position.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

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
    public LinkedList<Card> cardStack;
    public LinkedList<Card> rejectedCardStack;
    public ArrayList<Position> positions;


    /**
     * Creates a new instance of Controller and initializes the board and card stacks
     * @type Constructor
     */

    public Controller()
    {
        p1 = new Player("PLAYER 1");
        p2 = new Player("PLAYER 2");

        // prompt for the months to be played

        turn = ((new Random().nextInt() % 2 + 1) == 1 ? p1 : p2 ); // randomly select the first player


        init_board();
        init_cardStacks();
    }


    /**
     * Initializes the card stacks
     * @type Transformer
     */

    private void init_cardStacks()
    {
        cardStack = new LinkedList<>();
        rejectedCardStack = new LinkedList<>();

        // add all the cards in the game in the stack
    }

    /**
     * Initializes the positions
     * @type Transformer
     */

    private void init_board()
    {
        positions = new ArrayList<>();

        // add all the possible positions on the arraylist

        Collections.shuffle(positions); // shuffle the positions

    }

}
