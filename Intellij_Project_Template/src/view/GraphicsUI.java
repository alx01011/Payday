package view;


import controller.Controller;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Payday GUI
 *
 * @author Alexandros Antonakakis (csd4802)
 * @version 1.0
 */

public class GraphicsUI {
    Controller cntrl;
    Player player_blue, player_yellow;
    JFrame frame;
    customPanel base;
    customPanel jackpot;
    customPanel[] tiles;
    JDesktopPane p1;
    JDesktopPane p2;
    JDesktopPane board;
    JDesktopPane[] pos;
    JPanel dealCard, mailCard;
    JPanel p1_info;
    JTextField[] p1_data;
    JTextField[] p2_data;
    JTextField jackpot_amount;
    JButton getDealCard, getMailCard;
    JButton rollDice_p1, rollDice_p2;
    JButton dealCards_p1, dealCards_p2;
    JButton getLoan_p1, getLoan_p2;
    JButton endTurn_p1, endTurn_p2;
    JPanel infoBox;
    JTextField[] gameInfo;
    JLabel logo;
    JLabel dice_p1, dice_p2;
    JLabel pawn_blue, pawn_yellow;
    JMenu menu;
    JMenuBar menu_bar;
    JMenuItem new_game;
    JMenuItem save_game;
    JMenuItem load_game;
    JMenuItem exit;
    Controller controller;
    Image bg;  // used for different images
    ClassLoader cldr; // class loader to get the path to images

    private SundayFootballDayUI sundayFootballDayUI;
    private ThursdayRiseInCryptoUI thursdayRiseInCryptoUI;


    private final int width;
    private final int height;

    private final int MAX_POSITION = 32; // 32 positions

    /**
     * Creates a new window and adds buttons and panels for the players and board also starts the game
     *
     * @type Constructor
     * @Postcondition a new graphics ui instance is created
     */

    public GraphicsUI() {
        cldr = this.getClass().getClassLoader();
        width = Toolkit.getDefaultToolkit().getScreenSize().width - 200;
        height = Toolkit.getDefaultToolkit().getScreenSize().height - 50;
        cntrl = new Controller();

        cntrl.p1.setName(JOptionPane.showInputDialog("Player A : Name"));
        cntrl.p2.setName(JOptionPane.showInputDialog("Player B : Name"));

        Object[] options = { 1, 2, 3};
        cntrl.months_left = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]).toString());

        frame = new JFrame("Payday");
        base = new customPanel();
        jackpot = new customPanel();
        jackpot_amount = new JTextField();
        tiles = new customPanel[MAX_POSITION];
        board = new JDesktopPane();
        p1 = new JDesktopPane();
        p2 = new JDesktopPane();
        infoBox = new JPanel();
        mailCard = new JPanel();
        dealCard = new JPanel();
        getDealCard = new JButton();
        getMailCard = new JButton();
        gameInfo = new JTextField[4]; // info / months / turn / instruction
        p1_info = new JPanel();
        p1_data = new JTextField[3]; // money / loan /  bills
        p2_data = new JTextField[3]; // money / loan /  bills

        for (int i = 0; i < p1_data.length; i++)
        {
            p1_data[i] = new JTextField();
            p2_data[i] = new JTextField();
        }

        //p2_info = new JTextField[3];
        menu_bar = new JMenuBar();
        menu = new JMenu("Game");
        new_game = new JMenuItem("New Game");
        load_game = new JMenuItem("Load Game");
        save_game = new JMenuItem("Save Game");
        exit = new JMenuItem("Exit");
        logo = new JLabel();
        pos = new JDesktopPane[MAX_POSITION];
        pawn_blue = new JLabel();
        pawn_yellow = new JLabel();

        initialize_fields();
        init_session();
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

        tmp =  new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/pawn_blue.png"))).getImage().getScaledInstance(80, 80 ,Image.SCALE_SMOOTH);
        pawn_blue.setIcon(new ImageIcon(tmp));

        tmp =  new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/pawn_yellow.png"))).getImage().getScaledInstance(80, 80 ,Image.SCALE_SMOOTH);
        pawn_yellow.setIcon(new ImageIcon(tmp));


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(base);
        frame.setVisible(true);

        create_player_panels();
        info_box();
        card_buttons();
        board_positions();

        base.add(board);

        base.repaint();
        frame.pack();


        frame.setIconImage(new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/logo.png"))).getImage());
        frame.setResizable(false);

    }

    /**
     * Creates panels for the players
     *
     * @type Transformer
     * @Precondition Fields are initialized
     * @Postcondition panels are created
     */

    private void create_player_panels()
        {
        JTextField p1_name = new JTextField(cntrl.p1.getName());

        p1_name.setFont(new Font(null, Font.BOLD, 16));

        p1_name.setBorder(BorderFactory.createEmptyBorder());


        p1.setLayout(new BorderLayout());

        p1.add(p1_name, BorderLayout.NORTH); // place on top

        JDesktopPane info_p1 = new JDesktopPane();

        info_p1.setLayout(new BoxLayout(info_p1, BoxLayout.Y_AXIS));

        p1_data[0].setText("  Money: " + cntrl.p1.getBank_balance());
        p1_data[1].setText("  Loan: " + cntrl.p1.getLoans());
        p1_data[2].setText("  Bills: " + cntrl.p1.getBills());


        for (JTextField p1Datum : p1_data) {
            p1Datum.setEditable(false);
            p1Datum.setOpaque(false);
            p1Datum.setBorder(null);
            p1Datum.setFont(p1Datum.getFont().deriveFont(14f));
        }


        for (JTextField p1_datum : p1_data) {
            p1_datum.setBorder(BorderFactory.createEmptyBorder());
            info_p1.add(p1_datum);
        }


        rollDice_p1 = new JButton("Roll Dice");
        dealCards_p1 = new JButton("My Deal Cards");

        rollDice_p1.addActionListener(e -> dice_listener(dice_p1, rollDice_p1));

        info_p1.add(rollDice_p1);
        info_p1.add(Box.createVerticalStrut(5));

        info_p1.add(dealCards_p1);
        info_p1.add(Box.createVerticalStrut(5));



        JDesktopPane bottomButtons_p1 = new JDesktopPane();

        bottomButtons_p1.setLayout(new BoxLayout(bottomButtons_p1, BoxLayout.X_AXIS));

        getLoan_p1 = new JButton("Get Loan");

        bottomButtons_p1.add(getLoan_p1);
        bottomButtons_p1.add(Box.createHorizontalStrut(10));

        endTurn_p1 = new JButton("End Turn");

        endTurn_p1.addActionListener(e -> endTurn_listener());

        bottomButtons_p1.add(endTurn_p1);


        p1.add(info_p1, BorderLayout.CENTER);
        p1.add(bottomButtons_p1, BorderLayout.SOUTH);

        dice_p1 = new JLabel();

        Image tmp = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/dice-1.jpg"))).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        dice_p1.setIcon(new ImageIcon(tmp));
        dice_p1.setBackground(Color.white);
        dice_p1.setBorder(BorderFactory.createEmptyBorder());
        dice_p1.setOpaque(true);

        p1.add(dice_p1, BorderLayout.EAST);


        p1.setBounds(width * 2 / 3 + 50, 18, width / 4, height / 4 + 50);
        p1.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLUE));


        // ------------------------------------------- P2

        JTextField p2_name = new JTextField(cntrl.p2.getName());

        p2_name.setFont(new Font(null, Font.BOLD, 16));

        p2_name.setBorder(BorderFactory.createEmptyBorder());


        p2.setLayout(new BorderLayout());

        p2.add(p2_name, BorderLayout.NORTH); // place on top

        JDesktopPane info_p2 = new JDesktopPane();

        info_p2.setLayout(new BoxLayout(info_p2, BoxLayout.Y_AXIS));

        p2_data[0].setText("  Money: " + cntrl.p2.getBank_balance());
        p2_data[1].setText("  Loan: " + cntrl.p2.getLoans());
        p2_data[2].setText("  Bills: " + cntrl.p2.getBills());


        for (JTextField p2Datum : p2_data) {
            p2Datum.setEditable(false);
            p2Datum.setOpaque(false);
            p2Datum.setBorder(null);
            p2Datum.setFont(p2Datum.getFont().deriveFont(14f));
            p2Datum.setBorder(BorderFactory.createEmptyBorder());
            info_p2.add(p2Datum);
        }



        rollDice_p2 = new JButton("Roll Dice");
        rollDice_p2.addActionListener(e -> dice_listener(dice_p2, rollDice_p2));

        dealCards_p2 = new JButton("My Deal Cards");

        info_p2.add(rollDice_p2);
        info_p2.add(Box.createVerticalStrut(5));

        info_p2.add(dealCards_p2);
        info_p2.add(Box.createVerticalStrut(5));



        JDesktopPane bottomButtons_p2 = new JDesktopPane();

        bottomButtons_p2.setLayout(new BoxLayout(bottomButtons_p2, BoxLayout.X_AXIS));

        getLoan_p2 = new JButton("Get Loan");

        bottomButtons_p2.add(getLoan_p2);
        bottomButtons_p2.add(Box.createHorizontalStrut(10));

        endTurn_p2 = new JButton("End Turn");
        endTurn_p2.addActionListener(e -> endTurn_listener());


        bottomButtons_p2.add(endTurn_p2);


        p2.add(info_p2, BorderLayout.CENTER);
        p2.add(bottomButtons_p2, BorderLayout.SOUTH);

        dice_p2 = new JLabel();

        tmp = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/dice-1.jpg"))).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        dice_p2.setIcon(new ImageIcon(tmp));
        dice_p2.setBackground(Color.white);
        dice_p2.setBorder(BorderFactory.createEmptyBorder());
        dice_p2.setOpaque(true);

        p2.add(dice_p2, BorderLayout.EAST);


        p2.setBounds(width * 2 / 3 + 50, height - height / 3 - (height >= 1000 ? height / 23 : height / 15)  ,
                width / 4, height / 4 + 50);
        p2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.YELLOW));

            // disable second player buttons

            if (cntrl.turn == cntrl.p1)
        {
            rollDice_p2.setEnabled(false);
            endTurn_p2.setEnabled(false);
            endTurn_p1.setEnabled(false);
        }
        else
        {
            rollDice_p1.setEnabled(false);
            endTurn_p1.setEnabled(false);
            endTurn_p2.setEnabled(false);
        }

        base.add(p1);
        base.add(p2);
    }

    private void dice_listener(JLabel dice, JButton button)
    {
        cntrl.turn.getDice().rollDice();

        button.setEnabled(false);

        if (cntrl.turn == cntrl.p1)
        {
            endTurn_p1.setEnabled(true);
        }
        else
        {
            endTurn_p2.setEnabled(true);
        }

        int value = cntrl.turn.getDice().getValue();

        Image tmp = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/dice-" + value +".jpg"))).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        move_player(cntrl.turn, value);
        update_info_box();

        dice.setIcon(new ImageIcon(tmp));
        dice.repaint();
    }


    private void endTurn_listener()
    {
        if (cntrl.turn == cntrl.p1)
        {
            endTurn_p1.setEnabled(false);
            rollDice_p2.setEnabled(true);
        }
        else
        {
            endTurn_p2.setEnabled(false);
            rollDice_p1.setEnabled(true);
        }
        cntrl.nextTurn();
        update_info_box();

    }


    /**
     * Adds the info box to the frame
     */

    private void info_box()
    {
        infoBox.setBounds(width * 2 / 3 + 50, height - height / 3 - height / 3 , width / 4, height / 6);
        infoBox.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
        infoBox.setLayout(new GridLayout(4, 0));
        infoBox.setBorder(null);

        gameInfo[0] = new JTextField(" Info box:");
        gameInfo[0].setFont(new Font(null, Font.BOLD, 16));

        gameInfo[1] = new JTextField(" " + cntrl.months_left + " Month(s) Left");
        gameInfo[1].setFont(new Font(null, Font.BOLD, 14));

        gameInfo[2] = new JTextField(" Turn : " + cntrl.turn.getName());
        gameInfo[2].setFont(new Font(null, Font.BOLD, 14));

        gameInfo[3] = new JTextField(" -->A new game has started");
        gameInfo[3].setFont(new Font(null, Font.BOLD, 14));

        for (JTextField t : gameInfo) // clear the borders and add to info box
        {
            t.setBorder(BorderFactory.createEmptyBorder());
            infoBox.add(t);
        }
        base.add(infoBox);
    }

    private void update_info_box()
    {
        gameInfo[2].setText(" Turn : " + cntrl.turn.getName());
        gameInfo[2].repaint();
        gameInfo[1].setText(" " + cntrl.months_left + " Month(s) Left");
        gameInfo[1].repaint();

    }


    /**
     * Adds the card buttons to the board
     */

    private void card_buttons()
    {
        Image tmp = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/mailCard.png"))).getImage()
                .getScaledInstance(180, 90, Image.SCALE_SMOOTH);
        getMailCard.setIcon(new ImageIcon(tmp));

        tmp = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/dealCard.png"))).getImage()
                .getScaledInstance(180, 90, Image.SCALE_SMOOTH);
        getDealCard.setIcon(new ImageIcon(tmp));
        // add action listeners

        mailCard.add(getMailCard);
        dealCard.add(getDealCard);

        mailCard.setBounds(width * 2 / 3 + 50, height - height / 3 - height / 6 + 10, 180, 100);
        dealCard.setBounds(width * 2 / 3 + 50 + 250, height - height / 3 - height / 6 + 10, 180,  100);



        base.add(mailCard);
        base.add(dealCard);

    }


    /**
     * Initializes the board positions
     */


    private void jackpot_position()
    {
        Image tmp = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/jackpot.png"))).getImage().
                getScaledInstance(200, 90 , Image.SCALE_SMOOTH);

        jackpot.setBg(tmp);

        jackpot.setLayout(new BorderLayout());
        jackpot.setBounds(width * 2 / 5 , height - height / 3 -height / 23 + 200, 200, 100);

        jackpot_amount.setText("Jackpot : ");

        jackpot_amount.setBounds(width * 2 / 5, height - 20, 200, 100);
        jackpot.add(jackpot_amount, BorderLayout.SOUTH);
        jackpot_amount.setBorder(BorderFactory.createEmptyBorder());
        jackpot_amount.setFont(new Font(null, Font.BOLD, 15));

        base.add(jackpot);
    }

    private void board_positions()
    {
        board.setBounds(10, logo.getHeight() ,logo.getWidth(), height - logo.getHeight() );
        board.setSize(logo.getWidth() - 10, height - height / 4 + 30);
        board.setOpaque(false);
        board.setLayout(new GridLayout(0, 7));

        JTextField tileInfo = new JTextField();

        pos[0] = new JDesktopPane();
        pos[0].setLayout(new BorderLayout());
        tiles[0] = new customPanel();

        tileInfo.setText("Start");
        tileInfo.setBackground(Color.YELLOW);
        pos[0].add(tileInfo, BorderLayout.NORTH);
        board.add(pos[0]);
        Image tmp = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/start.png"))).getImage().getScaledInstance(width / 11, height / 7 ,Image.SCALE_SMOOTH);
        tiles[0].setBg(tmp);
        pos[0].add(tiles[0]);

        tiles[0].setLayout(new BorderLayout());
        tiles[0].add(pawn_blue, BorderLayout.CENTER);
        tiles[0].add(pawn_yellow, BorderLayout.EAST);

        for (int i = 1; i < MAX_POSITION; i++)
        {
            tileInfo = new JTextField();
            tiles[i] = new customPanel();

            pos[i] = new JDesktopPane();
            pos[i].setLayout(new BorderLayout());
            tileInfo.setText(cntrl.positions.get(i - 1).getDay().toString() + " " + cntrl.positions.get(i - 1).getDay_index());
            tileInfo.setBackground(Color.YELLOW);
            pos[i].add(tileInfo, BorderLayout.NORTH);
            tmp = new ImageIcon(Objects.requireNonNull(cntrl.positions.get(i - 1).getImageURL())).getImage().getScaledInstance(width / 11, height / 7, Image.SCALE_SMOOTH);
            tiles[i].setBg(tmp);
            pos[i].add(tiles[i]);

            board.add(pos[i]);
        }

        jackpot_position();

    }

    /**
     * Adds actions to each menu button
     */

    private void configure_menu_options()
    {
        exit.addActionListener(l ->
                System.exit(0));
    }

    private void move_player(Player p, int value)
    {
        int old_pos = cntrl.turn.getPosition();
        int new_pos = cntrl.turn.getPosition() + value > 31 ? 0 : cntrl.turn.getPosition() + value;

        if (p == cntrl.p1) {
            tiles[cntrl.p1.getPosition()].remove(pawn_blue);
            tiles[cntrl.p1.getPosition()].repaint();
            tiles[new_pos].add(pawn_blue, BorderLayout.CENTER);
            tiles[new_pos].repaint();
            cntrl.p1.setPosition(new_pos);
        }
        else
        {
            tiles[cntrl.p2.getPosition()].remove(pawn_yellow);
            tiles[cntrl.p2.getPosition()].repaint();
            tiles[new_pos].add(pawn_yellow, BorderLayout.CENTER);
            tiles[new_pos].repaint();
            cntrl.p2.setPosition(new_pos);
        }

        if (old_pos + value > 31 && cntrl.p1.getPosition() == 0 && cntrl.p2.getPosition() == 0)
        {
            cntrl.months_left--;
        }

    }


    /**
     * Starts a new game
     *
     * @type Transformer
     * @Precondition Fields and panels are initialized
     * @Postcondition a new game is started
     */

    private void init_session() {
        cntrl.turn.getDice().rollDice();
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
        new GraphicsUI();
    }
}