package online.devupgrade.sezon2.entities;

import online.devupgrade.sezon2.helper.IOrderStatus;
import online.devupgrade.sezon2.helper.IVisitor;

import javax.persistence.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Entity
public class Order extends Product {

    public static final int THREADS = 256;

    public Order() {

    }

    public IOrderStatus status;

    @Id
    @GeneratedValue
    public Integer id;

    @OneToMany
    private List<Product> products;

    @ManyToMany
    private List<DiscountEntity> discountEntities;

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

    public boolean setDiscountEntities(List<DiscountEntity> discountEntities) {
        this.discountEntities = discountEntities;
        return this.discountEntities != null || !this.discountEntities.isEmpty() ? true : false;
    }

    public Order setProducts(List<Product> products, Optional<IOrderStatus> orderStatus) {
        if (products == null) {
            products = new ArrayList<>();
        }
        if (orderStatus.isPresent()) {
            status = orderStatus.get();
        } else {
            if (products.size() > 0) {
                status = DefaultStatus.W_Przygotowaniu;
            }
        }
        boolean result = products.stream()
                .anyMatch(product -> product instanceof NotAProductProduct); //pattern matching
        this.products = products;
        if (result) {
            return new NotReallyOrderOrder(this);
        }
        return this;
    }

    public Future<Object> Visit(IVisitor visitor) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        Optional result = visitor.visit(products, Optional.of(Map.of("discount", discountEntities == null ? new ArrayList<>() : discountEntities)));
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
