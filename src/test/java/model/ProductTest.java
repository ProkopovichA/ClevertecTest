package model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void setterTest() {
        Product product = new Product("apple", 1, 2.5, false);

        product.setId(2);
        product.setDescription("green apple");
        product.setPrice(2.1);
        product.setDiscount(true);

        Assert.assertEquals(product.getId(), 2);
        Assert.assertEquals(product.getDescription(), "green apple");
        Assert.assertEquals(product.getPrice(), 2.1, 0);
        Assert.assertEquals(product.isDiscount(), true);
    }
}