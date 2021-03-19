package online.devupgrade.sezon2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EnterpriseOrderConstructorTests {

    @Test
    public void testOrderCompletePriceCalculator_green() {
        //Given
        Product first = new Product();
        first.setPrice(4f);
        Product second = new Product();
        second.setPrice(5f);
        ArrayList<Product> prods = new ArrayList<>();
        prods.add(first);
        prods.add(second);
        Order as = new Order();
        as.setProducts(prods);
        OrderPriceSumCalculator orderPriceSumCalculator = new OrderPriceSumCalculator();
        //when
        as.Visit(orderPriceSumCalculator);
        //result
        Assert.assertEquals(9f, (float)orderPriceSumCalculator.sumMantisa.sum, 0f);
    }
}
