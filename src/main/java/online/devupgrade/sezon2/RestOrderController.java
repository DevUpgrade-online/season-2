package online.devupgrade.sezon2;

import online.devupgrade.sezon2.dto.CreateEmptyOrderCommand;
import online.devupgrade.sezon2.dto.FindOrdersCommand;
import online.devupgrade.sezon2.utils.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RestOrderController {

    @Autowired
    Map<String, CommandHandler> handler;

    @PostMapping("/get/v1/orders/dto/json")
    List<OrderDTO> orders() {
        try {
            String commandName = FindOrdersCommand.class.getSimpleName();
            handler.get(commandName).handle(new FindOrdersCommand());
        } catch (ResultTransporterException e) {
            return (List<OrderDTO>) e.getData();
        }
        System.out.println("nie udalo sie");
        return List.of();
    }

    @PostMapping("/post/v1/createEmptyOrder/json")
    OrderDTO create() {
        try {
            String commandName = CreateEmptyOrderCommand.class.getSimpleName();
            handler.get(commandName).handle(new CreateEmptyOrderCommand());
        } catch (ResultTransporterException e) {
            return (OrderDTO) e.getData();
        }
        System.out.println("nie udalo sie");
        return OrderDTO.empty;
    }
}

