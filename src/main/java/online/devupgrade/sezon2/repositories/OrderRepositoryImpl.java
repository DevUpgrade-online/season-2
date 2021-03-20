package online.devupgrade.sezon2.repositories;

import online.devupgrade.sezon2.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryImpl extends JpaRepository<Order, Integer> {
}
