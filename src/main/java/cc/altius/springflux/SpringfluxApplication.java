package cc.altius.springflux;

import cc.altius.springflux.model.ResponseFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EntityScan("cc.altius.springflux.model")
@EnableReactiveMongoRepositories("cc.altius.springflux.repository")
@SpringBootApplication
public class SpringfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringfluxApplication.class, args);
        ResponseFormat.console("Spring WebFlux Server Started...!");
    }

}
