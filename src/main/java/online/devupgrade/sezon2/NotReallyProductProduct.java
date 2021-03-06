package online.devupgrade.sezon2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NotReallyProductProduct extends Product {

    NotReallyProductProduct(BigDecimal price, int count) {
        super(null, -1);
    }

    String formatPrice() {
        //???
        throw new IllegalStateException();
    }

}


