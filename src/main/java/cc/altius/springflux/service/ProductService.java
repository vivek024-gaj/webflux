/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.springflux.service;

import cc.altius.springflux.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Vivek Gajbhiye Altius Customer Service PVT. LTD.
 */
public interface ProductService {

    public Flux<Product> getAllProducts();

    public Mono<Product> getProductById(Integer productId);

    public Mono updateProduct(final Integer productId, final Product product);
    
    public Mono saveProduct(final Product product);
    
    public Mono deleteProduct(final Integer productId);
}
