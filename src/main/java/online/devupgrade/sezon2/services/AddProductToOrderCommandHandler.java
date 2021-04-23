package online.devupgrade.sezon2.services;

import online.devupgrade.sezon2.dto.AddProductToOrderCommand;
import online.devupgrade.sezon2.dto.ResultTransporterException;
import online.devupgrade.sezon2.utils.Command;
import online.devupgrade.sezon2.utils.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class AddProductToOrderCommandHandler implements CommandHandler {

    @Autowired
    ProductManagerLogicService productManagerLogicService;

    @Override
    public void handle(Command command) {
        AddProductToOrderCommand parsed = (AddProductToOrderCommand) command;
        productManagerLogicService.orderAddProduct(parsed.getOrderId(), parsed.getProductId());
        throw new ResultTransporterException(productManagerLogicService.loadOrder(parsed.getOrderId()));
    }
}
