package online.devupgrade.sezon2.utilshelpers;

import online.devupgrade.sezon2.entities.Product;
import online.devupgrade.sezon2.dto.ProductCommand;

import java.util.List;

public class DatabaseUtilsHelper {


    public enum TransactionIsolationLevel {
        JEDEN, DWA, TRZY //(jeden == read_uncommited) //TODO: przerobić na język language
    }


    public static List<Product> get(String products_table, Integer orderId, TransactionIsolationLevel jeden) {
        return null;
    }

    public static void save(String products_list, ProductCommand p1, TransactionIsolationLevel dwa) {
    }
}
