package online.devupgrade.sezon2.dto;

import online.devupgrade.sezon2.utils.Command;

public class AddProductToOrderCommand implements Command {
    private Integer productId;
    private Integer orderId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public AddProductToOrderCommand() {
    }

    public AddProductToOrderCommand(Integer productId, Integer orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }
}
