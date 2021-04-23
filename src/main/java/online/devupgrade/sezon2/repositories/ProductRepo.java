package online.devupgrade.sezon2.repositories;

import online.devupgrade.sezon2.entities.Order;
import online.devupgrade.sezon2.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductRepo {


    static ProductRepositoriesImpl staticProductRepositories;

    static List<Product> loadAllProductsFromOrder(Integer orderId) {
        return staticProductRepositories.findAll().stream().filter(a -> a.id.equals(orderId)).collect(Collectors.toList());
    }

    public static Object persist(Object p1) {
        staticProductRepositories.save((Product)p1);
        return p1;
    }

    public Product getProduct(Integer i){
        try {
            return staticProductRepositories.findAll().stream().filter(a-> !(a instanceof Order)).filter(x -> x.id == i).findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }

    @Autowired
    public void setRepo(ProductRepositoriesImpl staticProductRepositories){
        ProductRepo.staticProductRepositories = staticProductRepositories;
    }
}
