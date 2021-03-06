package online.devupgrade.sezon2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AgdProduct extends Product {


    AgdProduct(BigDecimal price, int count) {
        super(price, count);
    }

    String formatPrice() {
        return "Sprzęt kuchenny, kup za " + price.setScale(2, RoundingMode.HALF_UP);
    }

}


