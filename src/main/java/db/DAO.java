package db;

import model.DiscountCard;
import model.Product;

import java.util.List;

public interface DAO {
    public void addProductFromList(List<Product> products);
    public void addDiscountCardFromList(List<DiscountCard> cardList);
    public Product getProduct(int idProduct);
    public DiscountCard getCard(int cardNumber);

    public List<Product> getListProduct();
    public List<DiscountCard> getListCard();

}
