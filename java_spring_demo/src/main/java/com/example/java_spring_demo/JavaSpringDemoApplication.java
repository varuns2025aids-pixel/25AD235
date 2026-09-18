package com.example.java_spring_demo;

import com.example.java_spring_demo.entity.Library;
import com.example.java_spring_demo.repository.Libraryrepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class JavaSpringDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavaSpringDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner seedLibrary(Libraryrepository libraryRepository) {
        return args -> {
            if (libraryRepository.count() == 0) {
                libraryRepository.saveAndFlush(
                        new Library("Central Library", "Downtown")
                );
            }
        };
    }
}
