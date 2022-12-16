package model;

import java.io.Serializable;

public class FoodProduct extends Product implements Serializable {
    private int goodsWeight;

    public FoodProduct(String description, int id, double price, boolean discount) {
        super(description, id, price, discount);

    }


    public FoodProduct(String description, int id, double price, int goodsWeight, boolean discount) {
        super(description, id, price, discount);
        this.goodsWeight = goodsWeight;
    }
}
