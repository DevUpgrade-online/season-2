package online.devupgrade.sezon2;

import java.util.List;

public class DatabaseUtilsHelper {


    enum TransactionIsolationLevel {
        JEDEN, DWA, TRZY //(jeden == read_uncommited) //TODO: przerobić na język language
    }


    static List<Product> get(String products_table, Integer orderId, TransactionIsolationLevel jeden) {
        return null;
    }

    public static void save(String products_list, ProductCommand p1, TransactionIsolationLevel dwa) {
    }
}
