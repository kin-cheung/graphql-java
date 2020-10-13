package com.example.demo.resolvers;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
class Query implements GraphQLQueryResolver {

    private static List<Book> books = Arrays.asList(
            Book.of("book-1",
                    "Harry Potter and the Philosopher's Stone",
                    223,
                    "author-1"),
            Book.of("book-2",
                    "Moby Dick",
                    635,
                    "author-2"),
            Book.of("book-3",
                    "Interview with the vampire",
                    371,
                    "author-3")
    );

    public static List<Author> authors = Arrays.asList(
            Author.of("author-1",
                    "Joanne",
                    "Rowling"),
            Author.of("author-2",
                    "Herman",
                    "Melville"),
            Author.of("author-3",
                    "Anne",
                    "Rice")
    );

    Book bookById(String bookId) {
        return books
                .stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst()
                .orElse(null);
    }


}
