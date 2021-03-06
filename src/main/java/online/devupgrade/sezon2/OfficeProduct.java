package online.devupgrade.sezon2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OfficeProduct extends Product {


    OfficeProduct(BigDecimal price, int count) {
        super(price, count);
    }

    String formatPrice() {
        return "Artykuły biurowe. Kup za " + price.setScale(2, RoundingMode.HALF_UP);
    }

}


