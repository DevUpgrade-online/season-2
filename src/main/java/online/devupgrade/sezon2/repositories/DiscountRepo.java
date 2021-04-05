package online.devupgrade.sezon2.repositories;

import online.devupgrade.sezon2.entities.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepo extends JpaRepository<DiscountEntity, Long> {
}
