package db;

import model.DiscountCard;
import model.Product;
import model.builder.ProductObjectBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class LocalFileDAO implements DAO {
    private static LocalFileDAO instance;

    private LocalFileDAO() {
        if (!isFileExists("product.data")) {
            List<Product> products = new ArrayList<>();
            int productId = 1;
            ProductObjectBuilder productObjectBuilder = new ProductObjectBuilder();
            products.add(productObjectBuilder.setId(productId++).setDescription("Milk").setPrice(1.2).setDiscount(false).buildProduct());
            products.add(productObjectBuilder.setId(productId++).setDescription("Apple").setPrice(0.5).setDiscount(true).buildProduct());
            products.add(productObjectBuilder.setId(productId++).setDescription("Meat").setPrice(2).setDiscount(false).buildProduct());
            products.add(productObjectBuilder.setId(productId++).setDescription("Tea").setPrice(0.8).setDiscount(true).buildProduct());
            products.add(productObjectBuilder.setId(productId++).setDescription("Chocolate").setPrice(1).setDiscount(true).buildProduct());
            products.add(productObjectBuilder.setId(productId++).setDescription("Red hat").setPrice(10).setDiscount(false).buildProduct());
            products.add(productObjectBuilder.setId(productId++).setDescription("Black hat").setPrice(10).setDiscount(true).buildProduct());
            products.add(productObjectBuilder.setId(productId++).setDescription("T-shirt").setPrice(3).setDiscount(false).buildProduct());
            products.add(productObjectBuilder.setId(productId++).setDescription("Jeans").setPrice(15).setDiscount(false).buildProduct());
            products.add(productObjectBuilder.setId(productId++).setDescription("Boots").setPrice(20).setDiscount(true).buildProduct());
            createProducts(products);
        }

        if (!isFileExists("discount_card.data")) {
            List<DiscountCard> cardList = new ArrayList<>();
            for (int i = 0; i < 2000; i++) {
                cardList.add(new DiscountCard(i));
            }
            createDiscountCards(cardList);
        }
    }

    public static LocalFileDAO getInstance() {
        if (instance == null) {
            instance = new LocalFileDAO();
        }
        return instance;
    }

    private boolean isFileExists(String fileName) {
        File file = new File(fileName);
        return file.exists() && !file.isDirectory();
    }

    @Override
    public void createProducts(List<Product> products) {
        try (final FileOutputStream fos = new FileOutputStream("product.data"); final ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(products.size());
            for (Product p : products) {
                oos.writeObject(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createDiscountCards(List<DiscountCard> cardList) {
        try (final FileOutputStream fos = new FileOutputStream("discount_card.data"); final ObjectOutputStream oos = new ObjectOutputStream(fos)) {
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
        try (final FileInputStream fis = new FileInputStream("product.data"); final ObjectInputStream ois = new ObjectInputStream(fis)) {

            int productCount = ois.readInt();
            for (int i = 0; i < productCount; i++) {
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
        try (final FileInputStream fis = new FileInputStream("discount_card.data"); final ObjectInputStream ois = new ObjectInputStream(fis)) {
            int cardCount = ois.readInt();
            for (int i = 0; i < cardCount; i++) {
                card = (DiscountCard) ois.readObject();
                if (card.getCardNumber() == cardNumber) {
                    returnCard = card;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnCard;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();

        try (final FileInputStream fis = new FileInputStream("product.data"); final ObjectInputStream ois = new ObjectInputStream(fis)) {

            int productCount = ois.readInt();
            for (int i = 0; i < productCount; i++) {
                productList.add((Product) ois.readObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<DiscountCard> getCards() {
        List<DiscountCard> cardList = new ArrayList<>();
        DiscountCard returnCard = null;
        try (final FileInputStream fis = new FileInputStream("discount_card.data"); final ObjectInputStream ois = new ObjectInputStream(fis)) {
            int cardCount = ois.readInt();
            for (int i = 0; i < cardCount; i++) {
                cardList.add((DiscountCard) ois.readObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cardList;
    }
}
