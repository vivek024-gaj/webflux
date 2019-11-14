/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.springflux.repository;

import cc.altius.springflux.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vivek Gajbhiye Altius Customer Service PVT. LTD.
 */
@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product,Integer>{
    
}
