package model.builder;

import model.Product;

public interface ProductBuilder {
    ProductBuilder setId(int id);

    ProductBuilder setDescription(String description);

    ProductBuilder setPrice(double price);

    ProductBuilder setDiscount(boolean discount);

    public Product buildProduct();
}
