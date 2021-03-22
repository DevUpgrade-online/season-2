package online.devupgrade.sezon2.repositories;

import online.devupgrade.sezon2.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRepo {
//wzorzec adapter

    @Autowired
    OrderRepositoryImpl orderRepository;

    public Order load(Integer orderId) {
        return orderRepository.findById(orderId).isPresent() ? orderRepository.findById(orderId).get() : null;
    }

    public List<Order> loadAll() {
        return orderRepository.findAll();
    }
}
