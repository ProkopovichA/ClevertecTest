package model.builder;

import model.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ProductObjectBuilderTest {
    @Test
    public void builderTest() {
        ProductObjectBuilder builder = new ProductObjectBuilder();
        Product product = builder.setDescription("milk").setPrice(1.5).setId(5).setDiscount(true).buildProduct();

        Assert.assertEquals(product.getId(), 5);
        Assert.assertEquals(product.getDescription(), "milk");
        Assert.assertEquals(product.getPrice(), 1.5, 0);
        Assert.assertEquals(product.isDiscount(), true);
    }

}
