package online.devupgrade.sezon2.entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
public class Product implements Pricable {

    @Id
    @GeneratedValue
    public Integer id;

    @NotNull
    private float price;
    @NotNull
    private float pricePoPrzecinku;

    protected boolean isPriceGetOnce;

    private static final String KROPKA = ".";

    @Override
    public Float getPrice() {
        return price;
    }

    public Float getPrice(boolean canSee, Float promoPrice) {
        if (!isPriceGetOnce) {
            float[] split = XXxxxUtils.convert(promoPrice);
            price = split[0];
            pricePoPrzecinku = split[1];
            return promoPrice;
        }

        if (canSee) {
            isPriceGetOnce = true;
            return Float.parseFloat(price + KROPKA + pricePoPrzecinku);
        }
        return null;
    }

    public Float setPrice(Float price) {
        this.price = price;
        return price;
    }

    @Override
    public String toString() {
        return String.format("%d.%dPLN", price, pricePoPrzecinku);
    }
}

class XXxxxUtils {

    public static final String KROPKA = ".";

    static float[] convert(float price) {
        Float first = Arrays.asList(Float.valueOf(price).toString().replace(KROPKA, " ").split(" ")).stream().findFirst().map(p -> Float.valueOf(p)).get();
        Float second = Arrays.asList(Float.valueOf(price).toString().replace(KROPKA, " ").split(" "))
            .stream()
            .map(p -> Float.valueOf(p))
            .filter(p -> !p.equals(first))
            .findFirst().get();
        float[] result = new float[2];
        result[0] = first;
        result[1] = second;
        return result;
    }
}

class NotAProductProduct extends Product {

    @Override
    public Float getPrice() {
        isPriceGetOnce = true;
        return -1f;
    }
}

class ProductWithCurrency extends Product implements Pricable {
    private String currency;

    public String getCurrency() {
        return currency;
    }

    @Override
    public Float getPrice() {
        return null;
    }
}

class NotAProductProductWithCurrency extends ProductWithCurrency implements Pricable {

    @Override
    public Float getPrice() {
        return -1f;
    }
}

interface Pricable {
    Float getPrice();
}
