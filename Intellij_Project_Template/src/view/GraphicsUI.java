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
        loader = this.getClass().getClassLoader();
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

        board = new customPanel();
        frame.setVisible(true);
        frame.add(board);
        board.paintComponent(board.getGraphics());

        // expand the window to background image size

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(board, GroupLayout.PREFERRED_SIZE, 910, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(board, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE)
        );

        board.repaint();
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //imageURL = loader.getResource("resources/images/logo.png");

       // image = new ImageIcon(imageURL).getImage();

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
        public customPanel()
        {
            imageURL = loader.getResource("resources/images/bg_green.png");

            if (imageURL == null)
            {
                throw new NullPointerException("Background image not found");
            }

            image = new ImageIcon(imageURL).getImage();
        }

        @Override
        public void paintComponent(Graphics g) {

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