package online.devupgrade.sezon2.services;

import online.devupgrade.sezon2.dto.FindOrdersCommand;
import online.devupgrade.sezon2.dto.OrderDTO;
import online.devupgrade.sezon2.dto.ResultTransporterException;
import online.devupgrade.sezon2.utils.Command;
import online.devupgrade.sezon2.utils.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class FindOrdersCommandHandler implements CommandHandler {

    @Autowired
    ProductManagerLogicService productManagerLogicService;

    @Override
    public void handle(Command command) {
        if (command instanceof FindOrdersCommand) {
            List<OrderDTO> orders = productManagerLogicService.loadOrders();
            throw new ResultTransporterException(orders);
        }
        throw new IllegalStateException();
    }
}
