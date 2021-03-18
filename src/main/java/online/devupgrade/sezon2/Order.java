package online.devupgrade.sezon2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Entity
public class Order extends Product {

    public static final int THREADS = 256;

    public Order() {

    }

    private IOrderStatus status;

    @Id
    @GeneratedValue
    public Integer id;

    @OneToMany
    private List<Product> products;

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

    public Order setProducts(List<Product> products) {
        if (products == null) {
            products = new ArrayList<>();
        }
        boolean result = products.stream()
                .anyMatch(product -> product instanceof NotAProductProduct); //pattern matching
        this.products = products;
        if(result) {
            return new NotReallyOrderOrder(this);
        }
        return this;
    }

    public Future<Object> Visit(IVisitor visitor) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

         Optional result =visitor.visit(products, Optional.of(Map.of()));
         if (result.isPresent())
             return executorService.submit(new Callable<Object>() {
                 @Override
                 public Object call() throws Exception {
                     return result;
                 }
             });
         throw new IllegalStateException("Nie bede tu!");
    }
}


interface IVisitor {

    Optional<Boolean> visit(List<Product> products, Optional<Map<String, Object>> params);
}

//commmand
//command handler + controller
//adpater
//visitor
//kompozycja
//transporter wyjatkow
//pattern matching pattern
//singleton
//REST
//fluent interface
//YAGNI
//abstract state
//stala
//dziedziedziczenie
//OCP
//util
//factory
//marker interface
//optional
//future
//trojpodzial logiki - Optional<boolean>
//layers
//polimofirzm
//KISS
//REST
//service
//DAO
//DTO
//functional programming
//EDP (exception driven)
//Event-Driven-Arch
//IoC
//reactive
//wielowatkowosc (wspolbieznie i rozproszenie)
//reczna izolacja transakcji
//ORM
//Value Object (StringBasedOrderStatus)
//repozytorium
//separacja zagadnien
//dependency injection
//depdendency inversion
//porty i adaptery
//pluginowosc
//hexagonalana arch
//clean code + clean arch
//implementation by example
//instant delivery
//prawie event sourcing
//CQ(R)S
//security
//Mob Programming
//scrum
//agile

//framework-less


//triple lazy (LIE)
