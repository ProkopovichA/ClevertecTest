package model.builder;


import model.Product;

public class ProductObjectBuilder implements ProductBuilder {
    private String description;
    private int id;
    private double price;
    private boolean isDiscount;

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public void setDiscount(boolean discount) {
        this.isDiscount = discount;
    }

    public Product buildProduct() {
        return new Product(description, id, price, isDiscount);
    }
}
