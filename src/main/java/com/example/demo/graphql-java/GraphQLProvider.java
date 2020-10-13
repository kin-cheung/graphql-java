//package com.example.demo;
//
//import com.google.common.base.Charsets;
//import com.google.common.io.Resources;
//import graphql.GraphQL;
//import graphql.Scalars;
//import graphql.schema.GraphQLObjectType;
//import graphql.schema.GraphQLSchema;
//import graphql.schema.idl.RuntimeWiring;
//import graphql.schema.idl.SchemaGenerator;
//import graphql.schema.idl.SchemaParser;
//import graphql.schema.idl.TypeDefinitionRegistry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.net.URL;
//
//import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;
//
//@Component
//public class GraphQLProvider {
//    @Autowired
//    private GraphQLDataFetchers graphQLDataFetchers;
//    private GraphQL graphQL;
//    private GraphQLSchema graphQLSchema;
//
//    @Bean
//    public GraphQL graphQL() {
//        return graphQL;
//    }
//
//    @Bean
//    public GraphQLSchema graphQLSchema() {
//        return graphQLSchema;
//    }
//
//    @PostConstruct
//    public void init() throws IOException {
//        URL url = Resources.getResource("schema.graphqls");
//        String sdl = Resources.toString(url, Charsets.UTF_8);
//        graphQLSchema = buildSchema(sdl);
//        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
//    }
//
//    private GraphQLSchema buildSchema(String sdl) {
//        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
//        RuntimeWiring runtimeWiring = buildWiring();
//        SchemaGenerator schemaGenerator = new SchemaGenerator();
//        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
//    }
//
//    private RuntimeWiring buildWiring() {
//        return RuntimeWiring.newRuntimeWiring()
//                .type(newTypeWiring("Query")
//                        .dataFetcher("books", graphQLDataFetchers.getBooksFetcher())
//                        .dataFetcher("authors", graphQLDataFetchers.getAuthorsFetcher())
//                        .dataFetcher("bookById", graphQLDataFetchers.getBookByIdDataFetcher()))
//                .type(newTypeWiring("Book")
//                        .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher()))
//                .build();
//    }
//
//}