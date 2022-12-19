package model.check;

import model.Product;

public class CheckLine {
    private Product product;
    private int productQuantity;
    private double price;
    private double total;
    private double amountOfDiscount;

    public CheckLine(Product product, int productQuantity) {
        this.product = product;
        this.productQuantity = productQuantity;
        this.price = this.product.getPrice();
    }

    public void calculate() {
        total = price * productQuantity;
        total = total * (1 - amountOfDiscount / 100);
    }

    public void setAmountOfDiscount(double amountOfDiscount) {
        this.amountOfDiscount = amountOfDiscount;
    }

    @Override
    public String toString() {
        String returnSting = String.format(" %d  %-12s $%.2f  $%.2f ", productQuantity, product.getDescription(), price, total);
        if (amountOfDiscount != 0) {
            returnSting = returnSting + String.format("\ndiscount: %.0f", amountOfDiscount);
            returnSting = returnSting + "%";
        }
        return returnSting;
    }

    public double getTotal() {
        return total;
    }

    public Product getProduct() {
        return product;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getPrice() {
        return price;
    }

    public double getAmountOfDiscount() {
        return amountOfDiscount;
    }
}
