package online.devupgrade.sezon2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    protected BigDecimal price;
    protected int count;

    Product(BigDecimal price, int count) {
        this.price = price;
        this.count = count;
    }

    String formatPrice(String userType) {
        price = calculatePrice(userType);
        if (count > 10) {
            return "Kup za " + price.setScale(2, RoundingMode.HALF_UP);
        } else if (count > 5) {
            price = price.multiply(new BigDecimal(0.9));
            return "Spiesz się. Kup za " + price.setScale(2, RoundingMode.HALF_UP);
        } else {
            return "Ostatnie sztuki. Już teraz za " + price.setScale(2, RoundingMode.HALF_UP);
        }
    }

    BigDecimal calculatePrice(String userType) {
        if (userType.equals("VIP")) {
            return price.multiply(new BigDecimal(0.7));
        }
        return price;
    }
}


