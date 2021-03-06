package online.devupgrade.sezon2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WithdrawnAgdProduct extends RtvProduct {

    WithdrawnAgdProduct(BigDecimal price, int count) {
        super(price, count);
    }

    BigDecimal calculatePrice(String userType) {
        return BigDecimal.ZERO;
    }

}


