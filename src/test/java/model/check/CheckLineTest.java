package model.check;

import model.Product;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckLineTest {

    @Test
    public void calculate() {
        Product product = new Product("apple", 1, 2.5, true);
        CheckLine checkLine = new CheckLine(product,5);
        checkLine.calculate();

        Assert.assertEquals(checkLine.getTotal(),112.5, 0);


    }
}