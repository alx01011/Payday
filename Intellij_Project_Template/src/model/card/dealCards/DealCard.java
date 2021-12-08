package model.card.dealCards;

import model.card.Card;

public class DealCard implements Card {

    private int amount;
    private int original_amount;

    public DealCard(int amount, int original_amount)
    {
        this.amount = amount;
        this.original_amount = original_amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
