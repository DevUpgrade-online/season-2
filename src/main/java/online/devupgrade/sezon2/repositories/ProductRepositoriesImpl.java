package online.devupgrade.sezon2.repositories;

import online.devupgrade.sezon2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoriesImpl extends JpaRepository<Product, Integer> {
}
