package online.devupgrade.sezon2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private BigDecimal price;
    private int count;
    private String productType;

    Product(BigDecimal price, int count, String productType) {
        this.price = price;
        this.count = count;
        this.productType = productType;
    }

    String calculatePrice() {
        if (count > 10) {
            price = price.multiply(new BigDecimal(0.7));
            return "Kup za " + price.setScale(2, RoundingMode.HALF_UP);
        } else if (count > 5) {
            price = price.multiply(new BigDecimal(0.7));
            if (productType.equals("AGD")) {
                return "Codziennie niskie ceny. Cena wynosi: " + price.setScale(2, RoundingMode.HALF_UP);
            }
            return "Spiesz się. Kup za " + price.setScale(2, RoundingMode.HALF_UP);
        } else {
            price = price.multiply(new BigDecimal(1.1));
            return "Ostatnie sztuki. Już teraz za " + price.setScale(2, RoundingMode.HALF_UP);
        }
    }

    BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_UP);
    }
}

