package service;

import db.DAO;
import db.LocalFileDAO;
import model.Product;
import model.check.Check;
import model.check.CheckLine;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CheckServiceTest {



    @Test
    public void generateCheck() {
        Map<Integer, Integer> productQuantityMap = new HashMap<>();
        int cardNumber = 1234;
        String fileName = "product.data";
        productQuantityMap.put(3, 5);
        productQuantityMap.put(2, 5);
        productQuantityMap.put(6, 1);
        productQuantityMap.put(7, 4);
        productQuantityMap.put(8, 1);


        CheckRequest checkRequest = new CheckRequest(cardNumber, productQuantityMap, fileName);

        DAO daoObject = LocalFileDAO.getInstance();
        CheckService service = CheckService.getInstance();
        Check check = service.generateCheck(checkRequest,daoObject);

        Assert.assertEquals(check.getDiscountCard().getCardNumber(), cardNumber);

        List<CheckLine> checkLines = check.getCheckLines();

        int i = 0;
        Map<Integer, Integer> productsQuantity = productQuantityMap;
        for (Map.Entry<Integer, Integer> entry : productsQuantity.entrySet()) {
            Integer productId = entry.getKey();
            Integer productQuantity = entry.getValue();
            CheckLine checkLine = checkLines.get(i++);

            Assert.assertEquals(Integer.valueOf(checkLine.getProduct().getId()), productId);
            Assert.assertEquals(Integer.valueOf(checkLine.getProductQuantity()), productQuantity);

        }




    }

}