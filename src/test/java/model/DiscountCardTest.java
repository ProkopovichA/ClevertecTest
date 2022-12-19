package model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class DiscountCardTest {

    @Test
    public void getCardNumberDiscount() {
        DiscountCard discountCard = new DiscountCard(10);
        discountCard.setCardDiscount(50);

        Assert.assertEquals(discountCard.getCardNumber(), 10);
        Assert.assertEquals(discountCard.getCardDiscount(), 50);


    }


}