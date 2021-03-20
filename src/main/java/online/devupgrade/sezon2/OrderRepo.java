package online.devupgrade.sezon2;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
public class OrderRepo {
//wzorzec adapter

    @Autowired
    OrderRepositoryImpl orderRepository;

    Order load(Integer orderId) {
        return orderRepository.findById(orderId).isPresent() ? orderRepository.findById(orderId).get() : null;
    }

    List<Order> loadAll() {
        return orderRepository.findAll();
    }
}
