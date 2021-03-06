package online.devupgrade.sezon2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {


    @Test
    void wysokiStan() {
        Product p = new Product(BigDecimal.TEN, 20, "RTV");

        String text = p.calculatePrice();

        assertThat(p.getPrice()).isEqualByComparingTo(new BigDecimal(7));
        assertThat(text).isEqualTo("Kup za 7.00");
    }

    @Test
    void sredniStan() {
        Product p = new Product(BigDecimal.TEN, 6, "RTV");

        String text = p.calculatePrice();

        assertThat(p.getPrice()).isEqualByComparingTo(new BigDecimal(7));
        assertThat(text).isEqualTo("Spiesz się. Kup za 7.00");
    }

    @Test
    void niskiStan() {
        Product p = new Product(BigDecimal.TEN, 2, "RTV");

        String text = p.calculatePrice();

        assertThat(p.getPrice()).isEqualByComparingTo(new BigDecimal(11));
        assertThat(text).isEqualTo("Ostatnie sztuki. Już teraz za 11.00");
    }

    @Test
    void agd() {

        Product p = new Product(BigDecimal.TEN, 6, "AGD");

        String text = p.calculatePrice();

        assertThat(p.getPrice()).isEqualByComparingTo(new BigDecimal(7));
        assertThat(text).isEqualTo("Codziennie niskie ceny. Cena wynosi: 7.00");
    }

}