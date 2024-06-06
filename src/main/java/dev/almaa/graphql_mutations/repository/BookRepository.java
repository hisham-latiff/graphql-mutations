package dev.almaa.graphql_mutations.repository;

import dev.almaa.graphql_mutations.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
