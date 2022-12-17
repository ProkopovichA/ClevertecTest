package parser;

import service.CheckRequest;

import java.util.HashMap;
import java.util.Map;


public class CommandLineParser {
    public static CheckRequest parse(String[] args) {
        int cardNumber = -1;
        Map<Integer, Integer> productQuantityMap = new HashMap<>();
        String fileName = "";
        for (String arg : args) {
            if (arg.contains("card-")) {
                cardNumber = Integer.parseInt(arg.replace("card-", ""));
                //System.out.println("Find card № " + cardNumber);
            } else if (arg.contains("fileName")) {
                fileName = arg.replace("fileName-", "");
            } else {
                int indexOfDash = arg.indexOf("-");
                int productId = Integer.parseInt(arg.substring(0, indexOfDash));
                int productQuantity = Integer.parseInt(arg.substring(indexOfDash + 1, arg.length()));
                productQuantityMap.put(productId, productQuantity);
            }
        }
        CheckRequest checkRequest = new CheckRequest(cardNumber, productQuantityMap, fileName);
        return checkRequest;
    }
}
