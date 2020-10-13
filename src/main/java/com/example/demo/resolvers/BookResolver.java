package com.example.demo.resolvers;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    public Author author(Book book) {
        String authorId = book.getAuthorId();
        return Query.authors
                .stream()
                .filter(author -> author.getId().equals(authorId))
                .findFirst()
                .orElse(null);
    }

}