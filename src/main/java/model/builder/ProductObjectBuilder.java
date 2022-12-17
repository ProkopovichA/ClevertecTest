package model.builder;


import model.Product;

public class ProductObjectBuilder implements ProductBuilder {
    private String description;
    private int id;
    private double price;
    private boolean isDiscount;

    @Override
    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public ProductBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public ProductBuilder setDiscount(boolean discount) {
        this.isDiscount = discount;
        return this;
    }

    @Override
    public Product buildProduct() {
        return new Product(description, id, price, isDiscount);
    }
}
