package model.card;

/**
 * Card interface
 * @version 1.0
 * @author Alexandros Antonakakis (csd4802)
 */

public interface Card
{
    /**
     * Returns the cards value (price)
     * @return value
     */

    int getValue();

    /**
     * prints out the cards kind
     * @return card type
     */

    @Override
    String toString();
}
