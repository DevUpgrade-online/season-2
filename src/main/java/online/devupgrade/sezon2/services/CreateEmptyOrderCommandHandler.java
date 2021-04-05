package online.devupgrade.sezon2.services;

import online.devupgrade.sezon2.dto.CreateEmptyOrderCommand;
import online.devupgrade.sezon2.dto.OrderDTO;
import online.devupgrade.sezon2.dto.ResultTransporterException;
import online.devupgrade.sezon2.entities.Order;
import online.devupgrade.sezon2.utils.Command;
import online.devupgrade.sezon2.utils.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateEmptyOrderCommandHandler implements CommandHandler {

    @Autowired
    ProductManagerLogicService productManagerLogicService;

    @Override
    public void handle(Command command) {
        CreateEmptyOrderCommand parsed = (CreateEmptyOrderCommand) command;
        Order emptyOrder = productManagerLogicService.createEmptyOrder();
        throw new ResultTransporterException(new OrderDTO(emptyOrder.id));
    }
}
