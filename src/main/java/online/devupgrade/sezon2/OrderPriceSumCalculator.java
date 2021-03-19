package online.devupgrade.sezon2;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderPriceSumCalculator implements IVisitor {

    final SumProvider sumMantisa = new SumProvider();

    @Override
    public Optional<Boolean> visit(List<Product> products, Optional<Map<String, Object>> params) {
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
class SumProvider {
    static Float sum = 0f;

    public void add(Float a) {
        sum = sum + a;
    }

}
