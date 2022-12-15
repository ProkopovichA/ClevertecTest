public class InitDataBase {
    public static void Init(BaseOfCard baseOfCard, BaseOfProduct baseOfProduct) {
        FoodProductBuilder foodProductBuilder = new FoodProductBuilder();

        foodProductBuilder.setId(baseOfProduct.getFreeId());
        foodProductBuilder.setDescription("Milk");
        foodProductBuilder.setPrice(1.2);
        foodProductBuilder.setDiscount(false);
        baseOfProduct.addProduct(foodProductBuilder.getResult());

        foodProductBuilder.setId(baseOfProduct.getFreeId());
        foodProductBuilder.setDescription("Apple");
        foodProductBuilder.setPrice(0.5);
        foodProductBuilder.setDiscount(true);
        baseOfProduct.addProduct(foodProductBuilder.getResult());

        foodProductBuilder.setId(baseOfProduct.getFreeId());
        foodProductBuilder.setDescription("Meat");
        foodProductBuilder.setPrice(2);
        foodProductBuilder.setDiscount(false);
        baseOfProduct.addProduct(foodProductBuilder.getResult());

        foodProductBuilder.setId(baseOfProduct.getFreeId());
        foodProductBuilder.setDescription("Tea");
        foodProductBuilder.setPrice(0.8);
        foodProductBuilder.setDiscount(true);
        baseOfProduct.addProduct(foodProductBuilder.getResult());

        foodProductBuilder.setId(baseOfProduct.getFreeId());
        foodProductBuilder.setDescription("Chocolate");
        foodProductBuilder.setPrice(1);
        foodProductBuilder.setDiscount(true);
        baseOfProduct.addProduct(foodProductBuilder.getResult());

        ClothingProductBuilder clothingProductBuilder = new ClothingProductBuilder();
        clothingProductBuilder.setId(baseOfProduct.getFreeId());
        clothingProductBuilder.setDescription("Red hat");
        clothingProductBuilder.setPrice(10);
        clothingProductBuilder.setDiscount(false);
        baseOfProduct.addProduct(clothingProductBuilder.getResult());

        clothingProductBuilder.setId(baseOfProduct.getFreeId());
        clothingProductBuilder.setDescription("Black hat");
        clothingProductBuilder.setPrice(10);
        clothingProductBuilder.setDiscount(true);
        baseOfProduct.addProduct(clothingProductBuilder.getResult());

        clothingProductBuilder.setId(baseOfProduct.getFreeId());
        clothingProductBuilder.setDescription("T-shirt");
        clothingProductBuilder.setPrice(3);
        clothingProductBuilder.setDiscount(false);
        baseOfProduct.addProduct(clothingProductBuilder.getResult());

        clothingProductBuilder.setId(baseOfProduct.getFreeId());
        clothingProductBuilder.setDescription("Jeans");
        clothingProductBuilder.setPrice(15);
        clothingProductBuilder.setDiscount(false);
        baseOfProduct.addProduct(clothingProductBuilder.getResult());

        clothingProductBuilder.setId(baseOfProduct.getFreeId());
        clothingProductBuilder.setDescription("Boots");
        clothingProductBuilder.setPrice(20);
        clothingProductBuilder.setDiscount(true);
        baseOfProduct.addProduct(clothingProductBuilder.getResult());

        for (int i = 0; i < 2000; i++) {
            baseOfCard.addCard(new DiscountCard(i));
        }

//        baseOfProduct.printBase();
//        baseOfCard.printBase();

    }
}