package view;

import javax.swing.*;

/**
 * Sunday Football Day window
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class SundayFootballDay
{
    private JFrame frame;
    private JPanel panel_bet;
    private JPanel panel_result;
    private JButton[] button;
    private String ImageURL_1;
    private String ImageURL_2;


    /**
     * Creates a new instance of sunday football day window
     * @type Constructor
     */

    public SundayFootballDay()
    {
        init_fields();
    }


    /**
     * Initializes the class fields
     * @type Transformer
     */

    private void init_fields()
    {
        frame        = new JFrame("Sunday Football Day");
        panel_bet    = new JPanel();
        panel_result = new JPanel();
        button       = new JButton[6]; // 6 buttons

        button[0] = new JButton("Win Barcelona");
        button[1] = new JButton("Tie");
        button[2] = new JButton("Win Real Madrid");
        button[3] = new JButton("No bet");

        // add bets results and configure buttons

    }

}
