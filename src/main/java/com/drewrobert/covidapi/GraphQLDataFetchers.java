package com.drewrobert.covidapi;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> locations = Arrays.asList(
            ImmutableMap.of(
                    "id", "unitedstates",
                    "name", "United States of America"
            ),
            ImmutableMap.of(
                    "id", "canada",
                    "name", "Canada"
            ),
            ImmutableMap.of(
                    "id", "mexico",
                    "name", "Mexico"
            )
    );

    public DataFetcher getLocationByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return locations
                    .stream()
                    .filter(location -> location.get("id").equals(id))
                    .findFirst()
                    .orElse(null);
        };
    }
}
