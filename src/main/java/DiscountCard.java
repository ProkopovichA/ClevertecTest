public class DiscountCard {

    private int cardNumber;
    private int cardDiscount;

    public DiscountCard(int cardNumber) {
        this.cardNumber = cardNumber;
        this.cardDiscount = 5;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCardDiscount() {
        return cardDiscount;
    }

    public void setCardDiscount(int cardDiscount) {
        this.cardDiscount = cardDiscount;
    }

    @Override
    public String toString() {
        return "Card №" + cardNumber + ", card discount = " + cardDiscount + "%";
    }
}
