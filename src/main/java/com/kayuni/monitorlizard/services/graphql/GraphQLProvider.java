package com.kayuni.monitorlizard.services.graphql;

import java.io.IOException;

import javax.annotation.PostConstruct;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeRuntimeWiring;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.scalars.ExtendedScalars;
@Component
public class GraphQLProvider {
    private GraphQL graphQL;

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    @Bean
    public GraphQL graphQL() {
        return this.graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeRegistry = schemaParser.parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }
    
    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
            .scalar(ExtendedScalars.GraphQLLong)
            .type(TypeRuntimeWiring.newTypeWiring("Query")
                .dataFetcher("candlesticksFromTime", graphQLDataFetchers.getCandlesticksByTimeDataFetcher())
                .dataFetcher("candlesticks", graphQLDataFetchers.getAllCandlesticksDataFetcher())
                .dataFetcher("symbolByName", graphQLDataFetchers.getSymbolByNameDataFetcher()))
            // .type(TypeRuntimeWiring.newTypeWiring("Symbol")
        
            .build();

    }
}