package dev.aman.e_commerce_productservice.Services;

import dev.aman.e_commerce_productservice.Exceptions.ProductNotFound;
import dev.aman.e_commerce_productservice.Models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(long id) throws ProductNotFound;
    public List<Product> getAllProducts() throws ProductNotFound;
    public Product addProduct(Product product);
    public Product updateProduct(long id, Product product) throws ProductNotFound;
    public Product replaceProduct(long id, Product product) throws ProductNotFound;
    public void deleteProduct(long id) throws ProductNotFound;
}
