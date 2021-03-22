package online.devupgrade.sezon2;

import online.devupgrade.sezon2.entities.DefaultStatus;
import online.devupgrade.sezon2.entities.Order;
import online.devupgrade.sezon2.entities.Product;
import online.devupgrade.sezon2.utilshelpers.OrderPriceSumCalculator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

public class EnterpriseOrderConstructorTests {
    /*
    Klient robi zamówienie na dwa produkty,
    Zamówienie jest w stanie przygotowania (bo w jakim innym jak ma dwa produkty)
     */
    @Test
    public void testOrderCompletePriceCalculator_green() {
        //Given
        ArrayList<Product> prods = getDefaultProductList();
        Order as = new Order();
        as.setProducts(prods, Optional.empty());
        OrderPriceSumCalculator orderPriceSumCalculator = new OrderPriceSumCalculator();
        //when
        as.Visit(orderPriceSumCalculator);
        //result
        Assert.assertEquals(9f, (float) orderPriceSumCalculator.sumMantisa.sum, 0f);
        Assert.assertEquals(DefaultStatus.W_Przygotowaniu, as.status);
    }

    private ArrayList<Product> getDefaultProductList() {
        Product first = new Product();
        first.setPrice(4f);
        Product second = new Product();
        second.setPrice(5f);
        ArrayList<Product> prods = new ArrayList<>();
        prods.add(first);
        prods.add(second);
        return prods;
    }
}
