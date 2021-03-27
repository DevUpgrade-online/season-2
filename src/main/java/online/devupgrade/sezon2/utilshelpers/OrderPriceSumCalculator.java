package online.devupgrade.sezon2.utilshelpers;

import online.devupgrade.sezon2.helper.IVisitor;
import online.devupgrade.sezon2.entities.Product;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderPriceSumCalculator implements IVisitor {

    final public SumProvider sumMantisa = new SumProvider();

    @Override
    @Transactional
    public Optional<Boolean> visit(List<Product> products, Optional<Map<String, Object>> params) {
        sumMantisa.reset();
        products.forEach(
                product ->
                {
                    sumMantisa.add(product.getPrice());
                }
        );
        Float sum = sumMantisa.sum;
        return sum > 0f ? Optional.of(Boolean.TRUE) : Optional.empty();
    }
}
