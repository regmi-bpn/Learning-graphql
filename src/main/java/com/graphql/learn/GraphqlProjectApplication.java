package com.graphql.learn;

import com.graphql.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlProjectApplication implements CommandLineRunner {

    private final BookService bookService;

    @Autowired
    public GraphqlProjectApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphqlProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book b1 = new Book();
        b1.setTitle("Complete Reference");
        b1.setAuthor("Saraswati Shah");
        b1.setDescription("A book about freedom");
        b1.setPages(500);
        b1.setPrice(1000.0);

        Book b2 = new Book();
        b2.setTitle("Thin Book");
        b2.setAuthor("Aneesh Banjara");
        b2.setDescription("A book about thin people");
        b2.setPages(365);
        b2.setPrice(1099.0);

        Book b3 = new Book();
        b3.setTitle("Oka Book");
        b3.setAuthor("Oka Oka");
        b3.setDescription("A book about thin people");
        b3.setPages(365);
        b3.setPrice(1099.0);


        this.bookService.create(b1);
        this.bookService.create(b2);
        this.bookService.create(b3);
    }
}
