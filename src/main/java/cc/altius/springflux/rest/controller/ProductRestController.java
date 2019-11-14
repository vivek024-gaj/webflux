/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.springflux.rest.controller;

import cc.altius.springflux.model.Product;
import cc.altius.springflux.model.ResponseFormat;
import cc.altius.springflux.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author Vivek Gajbhiye Altius Customer Service PVT. LTD.
 */
@RestController
@RequestMapping("/webflux")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    @ApiOperation(value = "Create Lead", response = String.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Product Save Successfully")
        ,
        @ApiResponse(code = 401, message = "You are not authorized to view the resource")
        ,
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
        ,
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity saveProduct(
            @ApiParam(name = "productName", value = "productName")
            @RequestHeader(value = "productName")
            final String productName,
            @ApiParam(name = "description", value = "description")
            @RequestHeader(value = "description")
            final String description,
            @ApiParam(name = "price", value = "price")
            @RequestHeader(value = "price")
            final String price
    ) {
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setParameter("productName="+productName+"description="+description+"price="+price);
        try {
            Product product = new Product();
            product.setProductName(productName);
            product.setDescription(description);
            product.setPrice(price);
            ResponseFormat.console("productName="+productName+"description="+description+"price="+price);
            Mono saveProduct = this.productService.saveProduct(product);
            return new ResponseEntity(responseFormat, HttpStatus.OK);

        } catch (Exception e) {
            ResponseFormat.err("Exception occured");
            e.printStackTrace();
            responseFormat.setStatus("Failed");
            responseFormat.setFailedReason("Exception Occured");
            return new ResponseEntity(responseFormat, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
