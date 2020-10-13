package com.example.demo.resolvers;

import com.example.demo.models.Book;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Mutation implements GraphQLMutationResolver {

    public Book createBook(String name, int pageCount, String authorId) {
        return Book.of(UUID.randomUUID().toString(), name, pageCount, authorId);
    }

}