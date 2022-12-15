import java.util.ArrayList;
import java.util.List;

public class BaseOfProduct {
    private List<Product> products;

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


}
