package online.devupgrade.sezon2.services;

import online.devupgrade.sezon2.dto.OrderDTO;
import online.devupgrade.sezon2.dto.ProductCommand;
import online.devupgrade.sezon2.entities.DefaultStatus;
import online.devupgrade.sezon2.entities.Order;
import online.devupgrade.sezon2.entities.Product;
import online.devupgrade.sezon2.repositories.DiscountRepo;
import online.devupgrade.sezon2.repositories.OrderRepo;
import online.devupgrade.sezon2.repositories.ProductRepo;
import online.devupgrade.sezon2.utilshelpers.DatabaseUtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductManagerLogicService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private DiscountRepo discountRepo;
    @Autowired
    private ProductRepo productRepo;

    public OrderDTO loadOrder(Integer orderId) {
        Order order = orderRepo.load(orderId);
        List<Product> productsFromOrder = DatabaseUtilsHelper.get("products_table", orderId, DatabaseUtilsHelper.TransactionIsolationLevel.JEDEN); //1 = read uncommited
        productsFromOrder.forEach(product ->  order.getProducts().add(product));
        OrderDTO orderDTO = new OrderDTO(order, productsFromOrder); //TODO: use mapstruct
        return orderDTO;
    }
    
    public List<OrderDTO> loadOrders() {
        return orderRepo
                .loadAll()
                .stream()
                .map(o -> loadOrder(o.id))
                .collect(Collectors.toList());
    }

    public Order createEmptyOrder() {
        Order o = new Order();
        o.status = DefaultStatus.W_Przygotowaniu;
        return orderRepo.save(o);
    }

    void consumeProduct(java.util.function.Supplier<ProductCommand> consumer) {
         DatabaseUtilsHelper.save("products_list", consumer.get(), DatabaseUtilsHelper.TransactionIsolationLevel.DWA);
    }

    public void setOrderRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void orderAddProduct(Integer orderId, Integer productId) {
        try {
            Product product = productRepo.getProduct(productId);
            Order load = orderRepo.load(orderId);
            if(product == null) {
                throw new NoSuchElementException("Skonczyly sie takie produkty w bazie danych");
            }
            if(load == null) {
                throw new NoSuchElementException("Zamowienie takie nie jest w bazie teraz, probó/uj później");
            }
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            Object credentials = authentication.getCredentials();
//            Product newProduct = new Product();
//            newProduct.setPrice(product.getPrice());
            load.getProducts().add(product);
//            ProductRepo.persist(newProduct);
            orderRepo.save(load);
        } catch (Exception e) {
            System.err.println("Something goes no yes");
        } finally {
        }
    }
}
