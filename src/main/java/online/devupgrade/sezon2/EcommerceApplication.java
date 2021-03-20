package online.devupgrade.sezon2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EcommerceApplication
{
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }
}
