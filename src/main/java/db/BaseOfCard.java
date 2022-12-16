package db;

import model.DiscountCard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseOfCard implements Iterator {
    private List<DiscountCard> discountCards;
    private int indexOfBase;

    public BaseOfCard() {
        this.discountCards = new ArrayList<>();
    }

    public void addCard(DiscountCard discountCard) {
        if (!discountCards.contains(discountCard)) {
            discountCards.add(discountCard);
        } else {
            System.out.println("Discount card already added.");
        }
    }

    public DiscountCard getCard(int cardNumber) {
        for (DiscountCard card : discountCards) {
            if (cardNumber == card.getCardNumber()) {
                return card;
            }
        }
        return null;
    }

    public void printBase() {
        for (DiscountCard card : discountCards) {
            System.out.println(card);
        }
    }

    @Override
    public boolean hasNext() {
        return (indexOfBase < discountCards.size());
    }

    @Override
    public DiscountCard next() {
        return discountCards.get(indexOfBase++);
    }

    public void initIndexOfBase() {
        indexOfBase = 0;
    }
}
