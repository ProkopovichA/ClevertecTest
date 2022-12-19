package model.check;

import model.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CheckTest {

    @Test
    public void calculate() {
        Check check = new Check(1520);

        Product product = new Product("apple", 1, 2.5, false);
        CheckLine checkLine = new CheckLine(product,5);
        check.addProductToCheck(checkLine);

        product = new Product("milk", 2, 0.7, false);
        checkLine = new CheckLine(product,10);

        check.addProductToCheck(checkLine);
        check.calculate();

        Assert.assertEquals(19.5, check.getTotal(), 0);

        //With discount
        check = new Check(1520);
        product = new Product("apple", 1, 2.5, true);
        checkLine = new CheckLine(product,5);
        check.addProductToCheck(checkLine);

        product = new Product("milk", 2, 0.7, true);
        checkLine = new CheckLine(product,10);

        check.addProductToCheck(checkLine);
        check.calculate();

        Assert.assertEquals(18.8, check.getTotal(), 0);


    }
}