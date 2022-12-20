package service;

import db.DAO;
import db.LocalFileDAO;
import model.check.Check;
import model.check.CheckLine;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Check check = service.generateCheck(checkRequest, daoObject);

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

    @Test
    public void getDataBaseForPrint() {
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


        List<String> listOfDataBaseRecords = service.getDataBaseForPrint(checkRequest, daoObject);

        int sizeOfList = listOfDataBaseRecords.size();
        Assert.assertNotEquals(sizeOfList, 0);

        fileName = "discount_card.data";
        checkRequest = new CheckRequest(cardNumber, productQuantityMap, fileName);

        listOfDataBaseRecords = service.getDataBaseForPrint(checkRequest, daoObject);

        sizeOfList = listOfDataBaseRecords.size();
        Assert.assertNotEquals(sizeOfList, 0);

    }

}