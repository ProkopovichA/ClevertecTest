package service;

import db.DAO;

import model.DiscountCard;
import model.Product;
import model.check.Check;
import model.check.CheckLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckService {
    private Check check;
    private static CheckService instance;

    private CheckService() {

    }

    public static CheckService getInstance() {
        if (instance == null) {
            instance = new CheckService();
        }
        return instance;
    }

    public Check generateCheck(CheckRequest request, DAO daoObject) {
        check = new Check(1520);
        int cardNumber = request.cardNumber;
        if (cardNumber != -1) {
            DiscountCard card = daoObject.getCard(cardNumber);
            if (card != null) {
                check.setDiscountCard(card);
            } else {
                System.out.println("Card № " + cardNumber + " is no find in data base");
            }
        }

        Map<Integer, Integer> productsQuantity = request.productsQuantity;
        for (Map.Entry<Integer, Integer> entry : productsQuantity.entrySet()) {
            Integer productId = entry.getKey();
            Integer productQuantity = entry.getValue();
            Product product = daoObject.getProduct(productId);
            if ((product != null) && (productQuantity > 0)) {
                CheckLine checkLine = new CheckLine(product, productQuantity);
                check.addProductToCheck(checkLine);
            } else {
                System.out.println("Product id " + productId + " is no find in data base or quantity not more then 0");
            }
        }
        check.calculate();
        return check;
    }

    public List<String> printDataBase(CheckRequest request, DAO daoObject) {
        List<String> printArr = new ArrayList<>();
        String fileName = request.fileName;
        if (fileName.equals("product.data")) {
            printArr.add("Print: " + fileName);
            for (Product product : daoObject.getProducts()) {
                printArr.add(product.toString());
            }
        } else if (fileName.equals("discount_card.data")) {
            printArr.add("Print: " + fileName);
            for (DiscountCard card : daoObject.getCards()) {
                printArr.add(card.toString());
            }
        } else {
            printArr.add("Unknown file name");
        }
        return printArr;
    }

}
