package db;

import model.DiscountCard;
import model.DiscountCardTest;
import model.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LocalFileDAOTest {

    @Test
    public void createProducts() {
        DAO daoObject = LocalFileDAO.getInstance();
        List<Product> productList = daoObject.getProducts();
        int sizeOfList = productList.size();
        Assert.assertNotEquals(sizeOfList, 0);
    }

    @Test
    public void createDiscountCards() {
        DAO daoObject = LocalFileDAO.getInstance();
        List<DiscountCard> cardList = daoObject.getCards();
        int sizeOfList = cardList.size();
        Assert.assertNotEquals(sizeOfList, 0);
    }
}