package db;

import model.DiscountCard;
import model.builder.ProductObjectBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class InitDataBase {

    public static boolean isFileExists(String fileName) {
        File file = new File(fileName);
        return file.exists() && !file.isDirectory();
    }

    public static void init() {

        if (!isFileExists("product.data")) {
            try (final FileOutputStream fos = new FileOutputStream("product.data", true);
                 final ObjectOutputStream oos = new ObjectOutputStream(fos)) {


                int productId = 1;
                ProductObjectBuilder productObjectBuilder = new ProductObjectBuilder();
                productObjectBuilder.setId(productId++);
                productObjectBuilder.setDescription("Milk");
                productObjectBuilder.setPrice(1.2);
                productObjectBuilder.setDiscount(false);
                oos.writeObject(productObjectBuilder.buildProduct());

                productObjectBuilder.setId(productId++);
                productObjectBuilder.setDescription("Apple");
                productObjectBuilder.setPrice(0.5);
                productObjectBuilder.setDiscount(true);
                oos.writeObject(productObjectBuilder.buildProduct());

                productObjectBuilder.setId(productId++);
                productObjectBuilder.setDescription("Meat");
                productObjectBuilder.setPrice(2);
                productObjectBuilder.setDiscount(false);
                oos.writeObject(productObjectBuilder.buildProduct());

                productObjectBuilder.setId(productId++);
                productObjectBuilder.setDescription("Tea");
                productObjectBuilder.setPrice(0.8);
                productObjectBuilder.setDiscount(true);
                oos.writeObject(productObjectBuilder.buildProduct());

                productObjectBuilder.setId(productId++);
                productObjectBuilder.setDescription("Chocolate");
                productObjectBuilder.setPrice(1);
                productObjectBuilder.setDiscount(true);
                oos.writeObject(productObjectBuilder.buildProduct());


                productObjectBuilder.setId(productId++);
                productObjectBuilder.setDescription("Red hat");
                productObjectBuilder.setPrice(10);
                productObjectBuilder.setDiscount(false);
                oos.writeObject(productObjectBuilder.buildProduct());

                productObjectBuilder.setId(productId++);
                productObjectBuilder.setDescription("Black hat");
                productObjectBuilder.setPrice(10);
                productObjectBuilder.setDiscount(true);
                oos.writeObject(productObjectBuilder.buildProduct());

                productObjectBuilder.setId(productId++);
                productObjectBuilder.setDescription("T-shirt");
                productObjectBuilder.setPrice(3);
                productObjectBuilder.setDiscount(false);
                oos.writeObject(productObjectBuilder.buildProduct());

                productObjectBuilder.setId(productId++);
                productObjectBuilder.setDescription("Jeans");
                productObjectBuilder.setPrice(15);
                productObjectBuilder.setDiscount(false);
                oos.writeObject(productObjectBuilder.buildProduct());

                productObjectBuilder.setId(productId++);
                productObjectBuilder.setDescription("Boots");
                productObjectBuilder.setPrice(20);
                productObjectBuilder.setDiscount(true);
                oos.writeObject(productObjectBuilder.buildProduct());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!isFileExists("discount_card.data")) {
            try (final FileOutputStream fos = new FileOutputStream("discount_card.data", true);
                 final ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (int i = 0; i < 2000; i++) {
                    oos.writeObject(new DiscountCard(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


//        baseOfCard.printBase();
//        baseOfProduct.printBase();

    }
}
