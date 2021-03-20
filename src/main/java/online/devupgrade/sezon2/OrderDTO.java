package online.devupgrade.sezon2;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class OrderDTO {
    @JsonIgnore
    public static OrderDTO empty;

    private Integer id;

    public OrderDTO(Order order, List<Product> productsFromOrder) {

    }
}
