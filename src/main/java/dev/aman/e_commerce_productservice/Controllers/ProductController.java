package dev.aman.e_commerce_productservice.Controllers;

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
    public ProductController(@Qualifier("SelfProductService") ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFound {
        if(id < 1 || id > 20)
            throw new ProductNotFound("Product not found");
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
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
