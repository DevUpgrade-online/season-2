package online.devupgrade.sezon2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PromotionalOfficeProduct extends OfficeProduct {

    PromotionalOfficeProduct(BigDecimal price, int count) {
        super(price, count);
    }

    String formatPrice() {
        return "Artykuły biurowe. TERAZ TANIEJ!. Kup za " + price.setScale(2, RoundingMode.HALF_UP);
    }

}


