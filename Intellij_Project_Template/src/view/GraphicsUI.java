package view;

import model.card.dealCards.DealCard;
import model.card.messageCards.MailCard;

import javax.swing.*;

/**
 * Payday GUI
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class GraphicsUI
{
    JFrame frame;
    JPanel board;
    JPanel p1;
    JPanel p2;
    JMenu menu;
    JMenuBar menu_bar;
    final MailCard[] msg  = new MailCard[48]; // 48 message cards
    final DealCard    [] deal = new DealCard[20]; // 20 deal cards

    /**
     * Creates a new window and adds buttons and panels for the players and board
     * @type Constructor
     */

    public GraphicsUI()
    {

    }

    /**
     * Initializes the global frame, panels and menu fields
     * @type transformer
     */

    private void initialize_fields()
    {

    }

    /**
     * Initializes the deal and message cards per game
     * @type transformer
     */

    private void initialize_cards()
    {

    }

}
