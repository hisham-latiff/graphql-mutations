package dev.almaa.graphql_mutations.controller;


import dev.almaa.graphql_mutations.model.Book;
import dev.almaa.graphql_mutations.model.BookInput;
import dev.almaa.graphql_mutations.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument Integer pages, @Argument String author) {
        Book book = new Book(title, pages, author);
        return bookRepository.save(book);
    }

    /* mutation with object input type as argument*/
    @MutationMapping
    public Book addBook(@Argument(name = "book") BookInput bookInput) { // argument name must be same as argument in schema. if not annotated with (name="<name-in-schema>")
        Book book = new Book(bookInput.title(), bookInput.pages(), bookInput.author());
        return bookRepository.save(book);
    }

    /* mutation with list input type*/
    @MutationMapping
    public List<Book> batchCreate(@Argument List<BookInput> books) {
        return books.stream()
                .map(bookInput -> new Book(bookInput.title(), bookInput.pages(),bookInput.author()))
                .map(bookRepository::save)
                .collect(Collectors.toList());
    }
}
