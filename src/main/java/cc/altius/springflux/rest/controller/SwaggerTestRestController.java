/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.springflux.rest.controller;

import cc.altius.springflux.model.ResponseFormat;
import cc.altius.springflux.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
public class SwaggerTestRestController {

    @GetMapping("/hello/get")
    public Mono<String> getHello() {
        User u = new User();
        return Mono.just("Getting back..");
    }

    @PostMapping("/hello/post")
    public Mono<String> postHello() {
        return Mono.just("Posting back..");
    }

    @PostMapping("/user")
    @ApiOperation(value = "Save User Data", response = String.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "User save successfully")
        ,
        @ApiResponse(code = 401, message = "You are not Authorize to save user data")
        ,
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
        ,
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")

    })
    public ResponseEntity saveUser(
            @ApiParam(name = "name", value = "name", required = true)
            @RequestHeader(value = "name")
            final String name,
            @ApiParam(name = "age", value = "age", required = true)
            @RequestHeader(value = "age")
            final String age
    ) {
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setParameter("name=" + name + ",age=" + age);
        try {
            ResponseFormat.console("name="+name+",age="+age);
            return new ResponseEntity(name + " " + age, HttpStatus.OK);
        } catch (Exception e) {
            responseFormat.setFailedReason("Exception occured");
            responseFormat.setStatus("failed");
            return new ResponseEntity(responseFormat, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
