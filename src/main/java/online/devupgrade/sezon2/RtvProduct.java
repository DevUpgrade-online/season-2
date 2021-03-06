package online.devupgrade.sezon2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RtvProduct extends Product {


    RtvProduct(BigDecimal price, int count) {
        super(price, count);
    }

    String formatPrice() {
        return "Elektronika. Kup za " + price.setScale(2, RoundingMode.HALF_UP);
    }

}


