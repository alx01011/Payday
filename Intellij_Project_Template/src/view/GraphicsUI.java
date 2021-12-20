package view;


import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Payday GUI
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class GraphicsUI
{
    JFrame frame;
    JDesktopPane board;
    JPanel p1;
    JPanel p2;
    JMenu menu;
    JMenuBar menu_bar;
    Controller controller;
    URL imageURL;
    Image image;

    private SundayFootballDayUI sundayFootballDayUI;
    private ThursdayRiseInCryptoUI thursdayRiseInCryptoUI;

    /**
     * Creates a new window and adds buttons and panels for the players and board also starts the game
     * @type Constructor
     * @Postcondition a new graphicsui instance is created
     */

    public GraphicsUI()
    {
        initialize_fields();

    }

    /**
     * Initializes the global frame, panels and menu fields
     * @type Transformer
     * @Postcondition fields are initialized
     */

    private void initialize_fields()
    {
        frame = new JFrame("Payday");
        board = new JDesktopPane();
    }


    /**
     * Creates panels for the players
     * @type Transformer
     * @Precondition Fields are initialized
     * @Postcondition panels are created
     */

    private void create_player_panels()
    {

    }

    /**
     * Starts a new game
     * @type Transformer
     * @Precondition Fields and panels are initialized
     * @Postcondition a new game is started
     */

    private void init_session()
    {

    }

}
