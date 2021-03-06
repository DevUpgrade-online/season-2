package online.devupgrade.sezon2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PromotionalAgdProduct extends RtvProduct {

    PromotionalAgdProduct(BigDecimal price, int count) {
        super(price, count);
    }

    String formatPrice() {
        return "Sprzęt kuchenny w super cenie. Kup za " + price.setScale(2, RoundingMode.HALF_UP);
    }

}


