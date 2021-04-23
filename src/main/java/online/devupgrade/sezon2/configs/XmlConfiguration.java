package online.devupgrade.sezon2.configs;

import online.devupgrade.sezon2.entities.Product;
import online.devupgrade.sezon2.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.PostConstruct;

@Configuration
@ImportResource({"classpath*:applicationContext.xml"})
public class XmlConfiguration {

    @Autowired
    ProductRepo productRepo;

    @PostConstruct
    public void helperProducts() {
        //TODO: jakos ladniej
        if(productRepo.getProduct(0) != null)
        {}
            else
        ProductRepo.persist(new Product(0, 12f, 12f, true));
    }
}
