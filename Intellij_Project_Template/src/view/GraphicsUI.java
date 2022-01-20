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
    Controller cntrl;
    JFrame frame;
    customPanel base;
    JDesktopPane p1;
    JDesktopPane p2;
    JDesktopPane board;
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
        cntrl = new Controller();
        frame = new JFrame("Payday");
        base = new customPanel();
        board = new JDesktopPane();
        p1 = new JDesktopPane();
        menu_bar = new JMenuBar();
        menu = new JMenu("Game");
        new_game = new JMenuItem("New Game");
        load_game = new JMenuItem("Load Game");
        save_game = new JMenuItem("Save Game");
        exit = new JMenuItem("Exit");
        logo = new JLabel();
        pos = new JDesktopPane[MAX_POSITION];



        initialize_fields();
    }

    /**
     * Initializes the global frame, panels and menu fields
     *
     * @type Transformer
     * @Postcondition fields are initialized
     */

    private void initialize_fields() {
        frame.setPreferredSize(new Dimension(width, height));

        bg = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/bg_green.png"))).getImage();

        bg = bg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        base.setBg(bg); // set the background image

        menu.add(new_game);
        menu.add(load_game);
        menu.add(save_game);
        menu.add(exit);
        menu_bar.add(menu);
        frame.setJMenuBar(menu_bar);

        configure_menu_options();

        Image tmp = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/logo.png"))).getImage();

        tmp = tmp.getScaledInstance(width * 3 / 5 + 50 , height / 6 , Image.SCALE_SMOOTH);

        logo.setIcon(new ImageIcon(tmp));

        logo.setBounds(new Rectangle(new Point(0, 0),logo.getPreferredSize()));

        base.add(logo);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(base);
        frame.setVisible(true);
        base.paintComponent(base.getGraphics());

        players();
        board_positions();

        base.add(board);

        base.repaint();
        frame.pack();


        frame.setIconImage(new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/logo.png"))).getImage());
        frame.setResizable(false);
        System.err.println(pos[0].getSize());

    }

    private void players()
    {
        JLabel p1_name, p2_name;

        p1_name = new JLabel("  Player1");
        p2_name = new JLabel("  Player2");


        p1.setLayout(new BorderLayout());

        p1_name.setFont(new Font(null, Font.BOLD, 20));

        p1.add(p1_name, BorderLayout.NORTH);

        p1.setBounds(width * 2 / 3 + 50, 18, width / 4, height / 3);


        p2 = new JDesktopPane();

        p2.setLayout(new BorderLayout());

        p2_name.setFont(new Font(null, Font.BOLD, 20));

        p2.add(p2_name, BorderLayout.NORTH);

        p2.setBounds(width * 2 / 3 + 50, height - height / 3 - (height >= 1000 ? height / 13 : height / 7)  ,
                width / 4, height / 3);


        base.add(p1);
        base.add(p2);



    }

    /**
     * Initializes the board positions
     */

    private void board_positions()
    {
        board.setBounds(10, logo.getHeight() ,logo.getWidth(), height - logo.getHeight() );
        board.setSize(logo.getWidth() - 10, height - height / 4 + 30);
        board.setOpaque(false);
        board.setLayout(new GridLayout(0, 7));

        JTextField tileInfo = new JTextField();
        JLabel tile = new JLabel();

        pos[0] = new JDesktopPane();
        pos[0].setLayout(new BorderLayout());
        tileInfo.setText("Start");
        tileInfo.setBackground(Color.YELLOW);
        pos[0].add(tileInfo, BorderLayout.NORTH);
        board.add(pos[0]);
        Image tmp = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/start.png"))).getImage().getScaledInstance(153, 140 ,Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(tmp));

        pos[0].add(tile);

        for (int i = 1; i < MAX_POSITION; i++)
        {
            tileInfo = new JTextField();
            tile = new JLabel();

            pos[i] = new JDesktopPane();
            pos[i].setLayout(new BorderLayout());
            tileInfo.setText(cntrl.positions.get(i - 1).getDay().toString() + " " + cntrl.positions.get(i - 1).getDay_index());
            tileInfo.setBackground(Color.YELLOW);
            pos[i].add(tileInfo, BorderLayout.NORTH);
            tmp = new ImageIcon(Objects.requireNonNull(cntrl.positions.get(i - 1).getImageURL())).getImage().getScaledInstance(153, 140, Image.SCALE_SMOOTH);
            tile.setIcon(new ImageIcon(tmp));
            pos[i].add(tile);

            board.add(pos[i]);
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

        private Image bg;

        public void setBg(Image bg)
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