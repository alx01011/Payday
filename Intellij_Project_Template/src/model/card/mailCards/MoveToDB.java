package model.card.mailCards;

import model.player.Player;

/**
 * Move to the next Deal/Buyer square
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public class MoveToDB extends MailCard {

    /**
     * Create a new move to Deal/Buyer card
     * @type Constructor
     * @Postcondition A new instance of MoveToDB is created
     */

    public MoveToDB() {
        super(0, "Move to Deal/Buyer");
    }

    /**
     * Moves player p to the next DB position
     * @param p player to be moved
     * @type Transformer
     * @Precondition Player p is not null
     * @Postcondition Player p is moved to the nearest DB position
     */

    @Override
    public void action(Player p) {

    }
}
