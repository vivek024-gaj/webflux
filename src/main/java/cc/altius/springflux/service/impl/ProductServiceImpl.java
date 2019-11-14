/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.springflux.service.impl;

import cc.altius.springflux.model.Product;
import cc.altius.springflux.model.ResponseFormat;
import cc.altius.springflux.repository.ProductRepository;
import cc.altius.springflux.service.ProductService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Vivek Gajbhiye Altius Customer Service PVT. LTD.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Flux<Product> getAllProducts() {
        return this.productRepository.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Product> getProductById(Integer productId) {
        return this.productRepository.findById(productId);
    }

    @Override
    public Mono updateProduct(Integer productId, Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Mono saveProduct(Product product) {
        ResponseFormat.console("product in service  "+product);
        return this.productRepository.save(product);
    }

    @Override
    public Mono deleteProduct(Integer productId) {
        final Mono<Product> product = getProductById(productId);
        if(Objects.isNull(product)){
            return Mono.empty();
        }
        return getProductById(productId).switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull).flatMap(productToBeDeleted->this.productRepository.delete(productToBeDeleted)
                .then(Mono.just(productToBeDeleted)));
    }
}
