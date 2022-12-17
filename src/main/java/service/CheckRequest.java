package service;

import java.util.HashMap;
import java.util.Map;

public class CheckRequest {
    public int cardNumber;
    public Map<Integer, Integer> productsQuantity = new HashMap<>();
    public String fileName;

    public CheckRequest(int cardNumber, Map<Integer, Integer> productsQuantity, String fileName) {
        this.cardNumber = cardNumber;
        this.productsQuantity = productsQuantity;
        this.fileName = fileName;
    }
}
