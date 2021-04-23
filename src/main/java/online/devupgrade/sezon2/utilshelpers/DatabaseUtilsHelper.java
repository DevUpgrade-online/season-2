package online.devupgrade.sezon2.utilshelpers;

import online.devupgrade.sezon2.entities.Product;
import online.devupgrade.sezon2.dto.ProductCommand;
import online.devupgrade.sezon2.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DatabaseUtilsHelper {

    @Autowired
    ProductRepo productRepo;

    public enum TransactionIsolationLevel {
        JEDEN, DWA, TRZY //(jeden == read_uncommited) //TODO: przerobić na język language
    }


    public static List<Product> get(String products_table, Integer orderId, TransactionIsolationLevel jeden) {
        switch (jeden) {
            case DWA:
                return List.of();
        }
        return List.of();
    }

    public static List<Product> getDWA(Integer orderId) {

        return null;
    }

    public static List<Product> getJEDEN(Integer orderId) {

        return null;
    }



    public static void save(String products_list, ProductCommand p1, TransactionIsolationLevel dwa) {
    }
}
