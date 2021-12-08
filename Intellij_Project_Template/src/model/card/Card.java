package model.card;

public interface Card
{
    int getAmount();

    void setAmount(int amount);

    @Override
    String toString();
}
