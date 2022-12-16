package model;

import java.io.Serializable;

public class ClothingProduct extends Product implements Serializable{
    private int clothingSize;

    public ClothingProduct(String description, int id, double price, boolean discount) {
        super(description, id, price, discount);
    }

    public ClothingProduct(String description, int id, double price, int clothingSize, boolean discount) {
        super(description, id, price, discount);
        this.clothingSize = clothingSize;
    }
}
