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
    customPanel board;
    JPanel p1;
    JPanel p2;
    JMenu menu;
    JMenuBar menu_bar;
    Controller controller;
    URL imageURL;
    Image image;  // used for different images
    ClassLoader loader;

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
        loader = this.getClass().getClassLoader();
    }

    /**
     * Initializes the global frame, panels and menu fields
     * @type Transformer
     * @Postcondition fields are initialized
     */

    private void initialize_fields()
    {
        frame = new JFrame("Payday");
        board = new customPanel();
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

    /**
     * Panel with a custom background
     */

    class customPanel extends JDesktopPane
    {
        @Override
        public void paintComponent(Graphics g) {
            imageURL = loader.getResource("resources/images/bg_green.png");
            image = new ImageIcon(imageURL).getImage();
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }
}

/**
 * tester
 */

class Main
{
    public static void main(String[] args)
    {
        GraphicsUI g = new GraphicsUI();
    }
}