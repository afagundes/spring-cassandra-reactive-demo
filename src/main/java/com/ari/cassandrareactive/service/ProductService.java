package com.ari.cassandrareactive.service;

import com.ari.cassandrareactive.dto.ProductDTO;
import com.ari.cassandrareactive.model.Product;
import com.ari.cassandrareactive.repository.ProductRepository;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Flux<Product> findAll() {
        return repository.findAll();
    }

    public Mono<Product> save(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(Uuids.timeBased());
        product.setTitle(productDTO.getTitle());
        product.setQuantity(productDTO.getQuantity());
        product.setTags(productDTO.getTags());

        return repository.save(product);
    }

}
