package model_builder;

public interface ProductBuilder {
    void setId(int id);
    void setDescription(String description);
    void setPrice(double price);
    void setDiscount(boolean discount);
}
