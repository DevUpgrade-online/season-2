package online.devupgrade.sezon2;

import java.util.List;
import java.util.stream.Collectors;

public class ProductManagerLogicService {

    private OrderRepo orderRepo;

    OrderDTO loadOrder(Integer orderId) {
        Order order = orderRepo.load(orderId);
        List<Product> productsFromOrder = DatabaseUtilsHelper.get("products_table", orderId, DatabaseUtilsHelper.TransactionIsolationLevel.JEDEN); //1 = read uncommited
        productsFromOrder.forEach(product ->  order.getProducts().add(product));
        OrderDTO orderDTO = new OrderDTO(order, productsFromOrder); //TODO: use mapstruct
        return orderDTO;
    }
    
    List<OrderDTO> loadOrders() {
        return orderRepo
                .loadAll()
                .stream()
                .map(o -> loadOrder(o.id))
                .collect(Collectors.toList());
    }

    void consumeProduct(java.util.function.Supplier<ProductCommand> consumer) {
         DatabaseUtilsHelper.save("products_list", consumer.get(), DatabaseUtilsHelper.TransactionIsolationLevel.DWA);
    }

    public void setOrderRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
}
