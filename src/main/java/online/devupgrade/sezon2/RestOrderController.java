package online.devupgrade.sezon2;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class RestOrderController {

    CommandHandler handler;

    @PostMapping("/get/v1/orders/dto/json")
    List<OrderDTO> orders() {
        try {
            handler.handle(new FindOrdersCommand());
        } catch (ResultTransporterException e) {
            return (List<OrderDTO>) e.getData();
        }
        System.out.println("nie udalo sie");
        return List.of();
    }
}

interface Command {

}

class FindOrdersCommand implements Command {

}

interface CommandHandler {

    void handle(Command command);
}

class FindOrdersCommandHandler implements CommandHandler {

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
