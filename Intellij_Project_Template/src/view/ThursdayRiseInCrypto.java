package view;

import javax.swing.*;

/**
 * Thursday Rise in Crypto window
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class ThursdayRiseInCrypto
{

    private JFrame frame;
    private JPanel panel;
    private JButton[] button;
    private String ImageURL;

    /**
     * Creates a new instance of Crypto Thursday window
     * @type Constructor
     */

    public ThursdayRiseInCrypto()
    {

    }

    /**
     * initializes the crypto window fields
     * @type Transformer
     */

    private void init_fields()
    {
        frame = new JFrame("Crypto Thursday");
        button = new JButton[3];
        button[0] = new JButton("Bet on crypto");
        button[1] = new JButton("Skip bet");

        // add win/lose button and update panel


    }



}
