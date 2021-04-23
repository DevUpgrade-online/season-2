package online.devupgrade.sezon2;

import online.devupgrade.sezon2.dto.*;
import online.devupgrade.sezon2.utils.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        } catch (NullPointerException e) {
            return List.of();
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

    @PostMapping("/post/v1/products/add/json/{id}")
    OrderDTO create(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        try {
            String commandName = AddProductToOrderCommand.class.getSimpleName();
            handler.get(commandName).handle(new AddProductToOrderCommand(productDto.getId(), id));
        } catch (ResultTransporterException e) {
            return (OrderDTO) e.getData();
        }
        System.out.println("nie udalo sie");
        return OrderDTO.empty;
    }
}

