package online.devupgrade.sezon2;

import online.devupgrade.sezon2.entities.DefaultStatus;
import online.devupgrade.sezon2.entities.DiscountEntity;
import online.devupgrade.sezon2.entities.Order;
import online.devupgrade.sezon2.entities.Product;
import online.devupgrade.sezon2.utilshelpers.DiscountedPriceSumCalculator;
import online.devupgrade.sezon2.utilshelpers.OrderPriceSumCalculator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class EnterpriseOrderConstructorTests {
    /*
    Klient robi zamówienie na dwa produkty,
    Zamówienie jest w stanie przygotowania (bo w jakim innym jak ma dwa produkty)
     */
    @Test
    public void testOrderCompletePriceCalculator_green() throws ExecutionException, InterruptedException {
        //Given
        ArrayList<Product> prods = getDefaultProductList();
        Order as = new Order();
        as.setProducts(prods, Optional.empty());
        OrderPriceSumCalculator orderPriceSumCalculator = new OrderPriceSumCalculator();
        //when
        Object result = as.Visit(orderPriceSumCalculator).get();
        //result
        Assert.assertEquals(Optional.of(Boolean.TRUE), result);
        Assert.assertEquals(100f, (float) orderPriceSumCalculator.sumMantisa.sum, 0f);
        Assert.assertEquals(DefaultStatus.W_Przygotowaniu, as.status);
    }
    @Test
    public void testOrderCompletePriceCalculatorWithDiscount_green() throws ExecutionException, InterruptedException {
        //Given
        ArrayList<Product> prods = getDefaultProductList();
        Order as = new Order();
        DiscountEntity of = new DiscountEntity();
        of.setValue(20L);
        as.setDiscountEntities(List.of(of));
        as.setProducts(prods, Optional.empty());
        DiscountedPriceSumCalculator discountedPriceSumCalculator = new DiscountedPriceSumCalculator();
        //when
        Object result = as.Visit(discountedPriceSumCalculator).get();
        //result
        Assert.assertEquals(Optional.of(Boolean.TRUE), result);
        Assert.assertEquals(80f, (float) discountedPriceSumCalculator.sumMantisa.sum, 0f);
        Assert.assertEquals(DefaultStatus.W_Przygotowaniu, as.status);
    }

    @Test
    public void testOrderCompletePriceCalculatorWithDiscountExcluded_green() throws ExecutionException, InterruptedException {
        //Given
        ArrayList<Product> prods = getDefaultProductList();
        Order as = new Order();
        DiscountEntity of = new DiscountEntity();
        of.setValue(20L);
        of.setExcluded(List.of(prods.get(0)));
        as.setDiscountEntities(List.of(of));
        as.setProducts(prods, Optional.empty());
        DiscountedPriceSumCalculator discountedPriceSumCalculator = new DiscountedPriceSumCalculator();
        //when
        Object result = as.Visit(discountedPriceSumCalculator).get();
        //result
        Assert.assertEquals(Optional.of(Boolean.TRUE), result);
        Assert.assertEquals(32f, (float) discountedPriceSumCalculator.sumMantisa.sum, 0f);
        Assert.assertEquals(DefaultStatus.W_Przygotowaniu, as.status);
    }

    private ArrayList<Product> getDefaultProductList() {
        Product first = new Product();
        first.id = 1;
        first.setPrice(60.0f);
        Product second = new Product();
        second.id = 2;
        second.setPrice(40.0f);
        ArrayList<Product> prods = new ArrayList<>();
        prods.add(first);
        prods.add(second);
        return prods;
    }
}
