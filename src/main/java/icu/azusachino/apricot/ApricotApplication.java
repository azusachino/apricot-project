package icu.azusachino.apricot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * ApricotApplication
 */
@EnableCaching
@SpringBootApplication
public class ApricotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApricotApplication.class, args);
    }
}
