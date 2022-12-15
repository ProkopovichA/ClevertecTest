public abstract class Product {
    private String description;
    private int id;
    private double price;
    private boolean isDiscount;

    public Product(String description, int id, double price, boolean discount) {
        this.description = description;
        this.id = id;
        this.price = price;
        this.isDiscount = discount;
    }
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(boolean discount) {
        this.isDiscount = discount;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", isDiscount=" + isDiscount +
                '}';
    }
}
