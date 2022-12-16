package model;

import model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseOfProduct implements Iterator {
    private List<Product> products;
    private int indexOfBase;

    public BaseOfProduct() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (!products.contains(product)) {
            products.add(product);
        } else {
            System.out.println("Product already added.");
        }
    }

    public Product getProduct(int idProduct) {
        for (Product product : products) {
            if (idProduct == product.getId()) {
                return product;
            }
        }
        return null;
    }

    public int getFreeId() {
        return products.size();
    }

    public void printBase() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public boolean hasNext() {
        return (indexOfBase < products.size());
    }

    @Override
    public Product next() {
        return products.get(indexOfBase++);
    }

    public void initIndexOfBase() {
        indexOfBase = 0;
    }


}
