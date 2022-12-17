package parser;

import check.Check;
import check.CheckLine;
import db.DAO;
import model.DiscountCard;
import model.Product;


public class CommandLineParser {
    public static void parse(String[] args, Check check, DAO DaoObject) {
        for (String arg : args) {
            if (arg.contains("card-")) {
                int cardNumber = Integer.parseInt(arg.replace("card-", ""));
                //System.out.println("Find card № " + cardNumber);
                DiscountCard card = DaoObject.getCard(cardNumber);
                if (card != null) {
                    check.setDiscountCard(card);
                } else {
                    System.out.println("Card № " + cardNumber + " is no find in data base");
                }
            } else if (arg.contains("fileName")) {
                String fileName = arg.replace("fileName-", "");
                if (fileName.equals("product.data")) {
                    System.out.println("Print: " + fileName);
                    DaoObject.getListProduct().forEach(System.out::println);
                    System.out.println();
                } else if (fileName.equals("discount_card.data")) {
                    System.out.println("Print: " + fileName);
                    DaoObject.getListCard().forEach(System.out::println);
                    System.out.println();
                } else {
                    System.out.println("Unknown file name");
                }
            } else {
                int indexOfDash = arg.indexOf("-");
                int productId = Integer.parseInt(arg.substring(0, indexOfDash));
                int productQuantity = Integer.parseInt(arg.substring(indexOfDash + 1, arg.length()));
                Product product = DaoObject.getProduct(productId);
                //System.out.println("Find product id " + productId + ", quantity: " + productQuantity);
                if ((product != null) && (productQuantity > 0)) {
                    CheckLine checkLine = new CheckLine(product, productQuantity);
                    check.addProductToCheck(checkLine);
                } else {
                    System.out.println("Product id " + productId + " is no find in data base or quantity not more then 0");
                }
            }
        }
    }
}
