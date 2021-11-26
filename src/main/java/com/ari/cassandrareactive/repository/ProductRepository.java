package com.ari.cassandrareactive.repository;

import com.ari.cassandrareactive.model.Product;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends ReactiveCassandraRepository<Product, UUID> {
}
