package view;


import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

/**
 * Payday GUI
 *
 * @author Alexandros Antonakakis (csd4802)
 * @version 1.0
 */

public class GraphicsUI {
    JFrame frame;
    customPanel board;
    JDesktopPane p1;
    JDesktopPane p2;
    JDesktopPane[] pos;
    JLabel logo;
    JMenu menu;
    JMenuBar menu_bar;
    JMenuItem new_game;
    JMenuItem save_game;
    JMenuItem load_game;
    JMenuItem exit;
    Controller controller;
    URL imageURL;
    Image image, bg;  // used for different images
    ClassLoader cldr;

    private SundayFootballDayUI sundayFootballDayUI;
    private ThursdayRiseInCryptoUI thursdayRiseInCryptoUI;

    private final int width;
    private final int height;

    private final int MAX_POSITION = 32; // 32 positions

    /**
     * Creates a new window and adds buttons and panels for the players and board also starts the game
     *
     * @type Constructor
     * @Postcondition a new graphicsui instance is created
     */

    public GraphicsUI() {
        cldr = this.getClass().getClassLoader();
        width = Toolkit.getDefaultToolkit().getScreenSize().width - 200;
        height = Toolkit.getDefaultToolkit().getScreenSize().height - 50;

        initialize_fields();
    }

    /**
     * Initializes the global frame, panels and menu fields
     *
     * @type Transformer
     * @Postcondition fields are initialized
     */

    private void initialize_fields() {
        frame = new JFrame("Payday");
        frame.setPreferredSize(new Dimension(width, height));

        bg = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/bg_green.png"))).getImage();

        bg = bg.getScaledInstance(width, height, Image.SCALE_SMOOTH);


        board = new customPanel(bg);


        // expand the window to background image size



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

        configure_menu_options();

        logo = new JLabel();

        Image tmp = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/logo.png"))).getImage();

        tmp = tmp.getScaledInstance(width * 3 / 5 + 50 , height / 6 , Image.SCALE_SMOOTH);

        logo.setIcon(new ImageIcon(tmp));

        logo.setBounds(new Rectangle(new Point(0, 0),logo.getPreferredSize()));

        board.add(logo);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(board);
        frame.setVisible(true);
        board.paintComponent(board.getGraphics());

        players();

        board.repaint();
        frame.pack();


        frame.setIconImage(new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/logo.png"))).getImage());
        frame.setResizable(false);
    }

    private void players()
    {
        JLabel p1_name, p2_name;

        p1_name = new JLabel("  Player1");
        p2_name = new JLabel("  Player2");

        p1 = new JDesktopPane();

       // p1_name.setBounds(new Rectangle(new Point(width - 550 + 3, 20)));

        p1.setLayout(new BorderLayout());

        p1_name.setFont(new Font(null, Font.BOLD, 20));

        p1.add(p1_name, BorderLayout.NORTH);

        p1.setBounds(width - 550, 20, width / 4, 255);


        p2 = new JDesktopPane();

        //p2_name.setBounds(new Rectangle(new Point(width - 550 + 3, 20)));

        p2.setLayout(new BorderLayout());

        p2_name.setFont(new Font(null, Font.BOLD, 20));

        p2.add(p2_name, BorderLayout.NORTH);

        p2.setBounds(width - 550, 700, width / 4, 255);

        board.add(p1);
        board.add(p2);
    }

    /**
     * Initializes the board positions
     */

    private void board_positions()
    {
        GridLayout gridLayout = new GridLayout(0, 7);

        for (int i = 0; i < MAX_POSITION; i++)
        {
            pos[i] = new JDesktopPane();
        }
    }

    /**
     * Adds actions to each menu button
     */

    private void configure_menu_options()
    {
        exit.addActionListener(l ->
                System.exit(0));
    }

    /**
     * Creates panels for the players
     *
     * @type Transformer
     * @Precondition Fields are initialized
     * @Postcondition panels are created
     */

    private void create_player_panels() {

    }

    /**
     * Starts a new game
     *
     * @type Transformer
     * @Precondition Fields and panels are initialized
     * @Postcondition a new game is started
     */

    private void init_session() {

    }

    /**
     * Panel with a custom background
     */

    class customPanel extends JDesktopPane {

        private final Image bg;

        public customPanel(Image bg)
        {
            this.bg = bg;
        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.drawImage(bg, 0, 0, this);
        }
    }
}

/**
 * tester
 */

class Main {
    public static void main(String[] args) {
        GraphicsUI g = new GraphicsUI();
    }
}