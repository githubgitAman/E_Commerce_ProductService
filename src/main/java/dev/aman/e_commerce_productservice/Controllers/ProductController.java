package dev.aman.e_commerce_productservice.Controllers;

import dev.aman.e_commerce_productservice.AuthenticationCommons.AuthenticationComm;
import dev.aman.e_commerce_productservice.DTOs.UserDTO;
import dev.aman.e_commerce_productservice.Exceptions.ProductNotFound;
import dev.aman.e_commerce_productservice.Models.Product;
import dev.aman.e_commerce_productservice.Repositories.ProductRepository;
import dev.aman.e_commerce_productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    ProductService productService;
    AuthenticationComm authenticationComm;
    public ProductController(@Qualifier("SelfProductService") ProductService productService,
                             ProductRepository productRepository, AuthenticationComm authenticationComm) {
        this.productService = productService;
        this.productRepository = productRepository;
        this.authenticationComm = authenticationComm;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id, @RequestHeader String authenticationToken) throws ProductNotFound {
        //we are passing token in input parameter and then we will validate by calling user service
        UserDTO userDTO = authenticationComm.validateToken(authenticationToken);
        ResponseEntity<Product> responseEntity = null;
        if(userDTO == null) {
             responseEntity = new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
             return responseEntity;
        }
        if(id < 1 || id > 20)
            throw new ProductNotFound("Product not found");
        Product product = productService.getProductById(id);
        responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping
    public List<Product> getAllProducts() throws ProductNotFound {
        return productService.getAllProducts();
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws ProductNotFound {
        if(product == null)
            throw new ProductNotFound("Product not found");
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) throws ProductNotFound {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") long id, @RequestBody Product product) throws ProductNotFound {
        return new ResponseEntity<>(productService.replaceProduct(id, product), HttpStatus.OK);
    }

}
