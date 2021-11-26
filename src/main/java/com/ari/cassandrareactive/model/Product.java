package com.ari.cassandrareactive.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table
@Getter
@Setter
public class Product {

    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    private UUID id;

    @PrimaryKeyColumn(name = "title", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String title;

    private Integer quantity;
    private Set<String> tags = new HashSet<>();

}
