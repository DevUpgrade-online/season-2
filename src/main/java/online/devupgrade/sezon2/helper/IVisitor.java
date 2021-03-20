package online.devupgrade.sezon2.helper;

import online.devupgrade.sezon2.entities.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IVisitor {

    Optional<Boolean> visit(List<Product> products, Optional<Map<String, Object>> params);
}
