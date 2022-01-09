package view;


import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

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
    JLabel logo;
    JMenu menu;
    JMenuBar menu_bar;
    JMenuItem new_game;
    JMenuItem save_game;
    JMenuItem load_game;
    JMenuItem exit;
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
        frame.add(board);
        frame.setVisible(true);
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

        menu_bar = new JMenuBar();
        menu = new JMenu("Game");
        new_game = new JMenuItem("New Game");
        load_game = new JMenuItem("Load Game");
        save_game = new JMenuItem("Save Game");
        exit = new JMenuItem("Exit");

        menu.add(new_game);
        menu.add(load_game);
        menu.add(save_game);
        menu.add(exit);
        menu_bar.add(menu);
        frame.setJMenuBar(menu_bar);


        board.repaint();
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setIconImage(new ImageIcon(Objects.requireNonNull(loader.getResource("resources/images/logo.png"))).getImage());
        frame.setResizable(false);
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