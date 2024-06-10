package icu.azusachino.apricot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ApricotApplication
 */
@SpringBootApplication
public class ApricotApplication {
    
    public static void main(String[] args) {
        var app = new SpringApplication(ApricotApplication.class);
        app.run(args);
    }
}
