package com.ari.cassandrareactive.api.handler;

import com.ari.cassandrareactive.dto.ProductDTO;
import com.ari.cassandrareactive.model.Product;
import com.ari.cassandrareactive.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

    private final ProductService productService;

    public ProductHandler(ProductService productService) {
        this.productService = productService;
    }

    public Mono<ServerResponse> findAllProducts() {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productService.findAll(), Product.class);
    }

    public Mono<ServerResponse> createProduct(ServerRequest serverRequest) {
        Mono<ProductDTO> productToSave = serverRequest.bodyToMono(ProductDTO.class);

        return productToSave.flatMap(product ->
                ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productService.save(product), Product.class));
    }

}
