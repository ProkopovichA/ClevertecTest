package db;


import model.DiscountCard;
import model.Product;

import java.io.*;
import java.time.LocalDateTime;

public class FileDAO {

    public static Product getProduct(int idProduct) {
        Product product;
        Product returnProduct = null;
        try (final FileInputStream fis = new FileInputStream("product.data");
             final ObjectInputStream ois = new ObjectInputStream(fis)) {

            for (; ; ) {
                product = (Product) ois.readObject();
                if (product.getId() == idProduct) {
                    returnProduct = product;
                    break;
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return returnProduct;
    }

    public static DiscountCard getCard(int cardNumber) {
        DiscountCard card;
        DiscountCard returnCard = null;
        try (final FileInputStream fis = new FileInputStream("discount_card.data");
             final ObjectInputStream ois = new ObjectInputStream(fis)) {

            for (; ; ) {
                card = (DiscountCard) ois.readObject();
                if (card.getCardNumber() == cardNumber) {
                    returnCard = card;
                    break;
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return returnCard;
    }


}
