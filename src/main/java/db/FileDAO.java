package db;


import model.DiscountCard;
import model.Product;

import java.io.*;
import java.util.List;

public final class FileDAO implements DAO {
    private static FileDAO instance;

    private FileDAO() {

    }

    public static FileDAO getInstance() {
        if (instance == null) {
            instance = new FileDAO();
        }
        return instance;
    }

    @Override
    public void addProductFromList(List<Product> products) {
        try (final FileOutputStream fos = new FileOutputStream("product.data");
             final ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(products.size());
            for (Product p : products) {
                oos.writeObject(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addDiscountCardFromList(List<DiscountCard> cardList) {
        try (final FileOutputStream fos = new FileOutputStream("discount_card.data");
             final ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(cardList.size());
            for (DiscountCard card : cardList) {
                oos.writeObject(card);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProduct(int idProduct) {
        Product product;
        Product returnProduct = null;
        try (final FileInputStream fis = new FileInputStream("product.data");
             final ObjectInputStream ois = new ObjectInputStream(fis)) {

            int productCount = ois.readInt();
            for (int i=0; i< productCount; i++) {
                product = (Product) ois.readObject();
                if (product.getId() == idProduct) {
                    returnProduct = product;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnProduct;
    }

    @Override
    public DiscountCard getCard(int cardNumber) {
        DiscountCard card;
        DiscountCard returnCard = null;
        try (final FileInputStream fis = new FileInputStream("discount_card.data");
             final ObjectInputStream ois = new ObjectInputStream(fis)) {
            int cardCount = ois.readInt();
            for (int i=0; i< cardCount; i++) {
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
