package db;

import model.DiscountCard;
import model.Product;
import model.builder.ProductObjectBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InitDataBase {


    public static boolean isFileExists(String fileName) {
        File file = new File(fileName);
        return file.exists() && !file.isDirectory();
    }

    public static void init(DAO DaoObject) {

        if (!isFileExists("product.data")) {
            List<Product> products = new ArrayList<>();
            int productId = 1;
            ProductObjectBuilder productObjectBuilder = new ProductObjectBuilder();
            productObjectBuilder.setId(productId++);
            productObjectBuilder.setDescription("Milk");
            productObjectBuilder.setPrice(1.2);
            productObjectBuilder.setDiscount(false);
            products.add(productObjectBuilder.buildProduct());

            productObjectBuilder.setId(productId++);
            productObjectBuilder.setDescription("Apple");
            productObjectBuilder.setPrice(0.5);
            productObjectBuilder.setDiscount(true);
            products.add(productObjectBuilder.buildProduct());

            productObjectBuilder.setId(productId++);
            productObjectBuilder.setDescription("Meat");
            productObjectBuilder.setPrice(2);
            productObjectBuilder.setDiscount(false);
            products.add(productObjectBuilder.buildProduct());

            productObjectBuilder.setId(productId++);
            productObjectBuilder.setDescription("Tea");
            productObjectBuilder.setPrice(0.8);
            productObjectBuilder.setDiscount(true);
            products.add(productObjectBuilder.buildProduct());

            productObjectBuilder.setId(productId++);
            productObjectBuilder.setDescription("Chocolate");
            productObjectBuilder.setPrice(1);
            productObjectBuilder.setDiscount(true);
            products.add(productObjectBuilder.buildProduct());


            productObjectBuilder.setId(productId++);
            productObjectBuilder.setDescription("Red hat");
            productObjectBuilder.setPrice(10);
            productObjectBuilder.setDiscount(false);
            products.add(productObjectBuilder.buildProduct());

            productObjectBuilder.setId(productId++);
            productObjectBuilder.setDescription("Black hat");
            productObjectBuilder.setPrice(10);
            productObjectBuilder.setDiscount(true);
            products.add(productObjectBuilder.buildProduct());

            productObjectBuilder.setId(productId++);
            productObjectBuilder.setDescription("T-shirt");
            productObjectBuilder.setPrice(3);
            productObjectBuilder.setDiscount(false);
            products.add(productObjectBuilder.buildProduct());

            productObjectBuilder.setId(productId++);
            productObjectBuilder.setDescription("Jeans");
            productObjectBuilder.setPrice(15);
            productObjectBuilder.setDiscount(false);
            products.add(productObjectBuilder.buildProduct());

            productObjectBuilder.setId(productId++);
            productObjectBuilder.setDescription("Boots");
            productObjectBuilder.setPrice(20);
            productObjectBuilder.setDiscount(true);
            products.add(productObjectBuilder.buildProduct());

            DaoObject.addProductFromList(products);
        }

        if (!isFileExists("discount_card.data")) {
            List<DiscountCard> cardList = new ArrayList<>();
            for (int i = 0; i < 2000; i++) {
                cardList.add(new DiscountCard(i));
            }
            DaoObject.addDiscountCardFromList(cardList);
        }


//        baseOfCard.printBase();
//        baseOfProduct.printBase();

    }
}
