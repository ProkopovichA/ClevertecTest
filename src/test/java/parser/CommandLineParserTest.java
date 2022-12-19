package parser;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import service.CheckRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CommandLineParserTest {

    @Test
    public void parse() {

        String[] args = new String[8];
        args[0] = "3-5";
        args[1] = "2-5";
        args[2] = "6-1";
        args[3] = "7-4";
        args[4] = "8-1";
        args[5] = "12-10";
        args[6] = "card-1234";
        args[7] = "fileName-product.data";

        CheckRequest checkRequestResult = CommandLineParser.parse(args);

        Map<Integer, Integer> productQuantityMap = new HashMap<>();
        int cardNumber = 1234;
        String fileName = "product.data";
        productQuantityMap.put(3, 5);
        productQuantityMap.put(2, 5);
        productQuantityMap.put(6, 1);
        productQuantityMap.put(7, 4);
        productQuantityMap.put(8, 1);
        productQuantityMap.put(12, 10);
        CheckRequest checkRequestActual = new CheckRequest(cardNumber, productQuantityMap, fileName);

        Assert.assertEquals(checkRequestResult.cardNumber, checkRequestActual.cardNumber);
        Assert.assertEquals(checkRequestResult.productsQuantity, checkRequestActual.productsQuantity);
        Assert.assertEquals(checkRequestResult.fileName, checkRequestActual.fileName);


    }
}