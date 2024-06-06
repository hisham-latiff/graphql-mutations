package dev.almaa.graphql_mutations;

import dev.almaa.graphql_mutations.model.Book;
import dev.almaa.graphql_mutations.model.Review;
import dev.almaa.graphql_mutations.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class GraphqlMutationsApplication {

	@Bean
	public CommandLineRunner initData(BookRepository bookRepository){
		return args -> {
			Book book = new Book("Reactive Spring", 484, "Josh Long");
			Review review = new Review("Great book!", "I really enjoyed this book!");
			book.setReviews(Collections.singletonList(review));
			bookRepository.save(book);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(GraphqlMutationsApplication.class, args);
	}

}
