package online.devupgrade.sezon2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import online.devupgrade.sezon2.entities.Order;
import online.devupgrade.sezon2.entities.Product;

import java.util.List;

public class OrderDTO {
    @JsonIgnore
    public static OrderDTO empty;

    private Integer id;

    public OrderDTO(Order order, List<Product> productsFromOrder) {

    }

    public static OrderDTO getEmpty() {
        return empty;
    }

    public static void setEmpty(OrderDTO empty) {
        OrderDTO.empty = empty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderDTO(Integer id) {
        this.id = id;
    }
}
