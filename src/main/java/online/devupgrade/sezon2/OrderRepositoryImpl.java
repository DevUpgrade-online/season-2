package online.devupgrade.sezon2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryImpl extends CrudRepository<Order, Integer> {
}
