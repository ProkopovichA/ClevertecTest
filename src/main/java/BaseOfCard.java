import java.util.ArrayList;
import java.util.List;

public class BaseOfCard {
    private List<DiscountCard> discountCards;

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

}
