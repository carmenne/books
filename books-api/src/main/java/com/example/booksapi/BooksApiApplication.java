package com.example.booksapi;

import com.example.booksapi.data.BookRepository;
import com.example.booksapi.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;

import java.net.URI;

@SpringBootApplication
public class BooksApiApplication {

    private static final Logger log = LoggerFactory.getLogger(BooksApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BooksApiApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(BookRepository bookRepository) {
        return args -> {
            // Save the books
            bookRepository.save(Book.builder().title("Effective Java").author("Joshua Bloch").build());
            bookRepository.save(Book.builder().title("Java concurrency in practice").author("Brian Goetz").build());

            log.info("Books found with findAll():");
            log.info("-------------------------------");
            bookRepository.findAll().forEach(
                    book -> log.info(book.toString())
            );
            log.info("");
        };
    }
}
