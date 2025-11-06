package com.otsuguasoft;

import com.otsuguasoft.serviciobdd.model.Informacion;
import com.otsuguasoft.serviciobdd.repository.InformacionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServicioBddApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioBddApplication.class, args);
    }
    
    /*@Bean
    CommandLineRunner checkRedis(RedisConnectionFactory connectionFactory) {
        return args -> {
            try {
                connectionFactory.getConnection().ping();
                System.out.println("✅ Conexión a Redis exitosa.");
            } catch (Exception e) {
                System.err.println("❌ Redis no está disponible: " + e.getMessage());
            }
        };
    }*/

    /*
    @Bean
    CommandLineRunner init(InformacionRepository repo) {
        return args -> {
            repo.save(new Informacion("123", "Descripción para ID 123"));
            repo.save(new Informacion("456", "Descripción para ID 456"));
        };
    }
    */
}