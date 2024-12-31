package dev.aman.e_commerce_productservice.Services;

import dev.aman.e_commerce_productservice.Exceptions.ProductNotFound;
import dev.aman.e_commerce_productservice.Models.Product;
import dev.aman.e_commerce_productservice.Repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service("SelfProductService")
public class SelfProductService implements ProductService {
    ProductRepository productRepository;
    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFound {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFound {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(long id, Product product) throws ProductNotFound{
        Product newProduct = productRepository.findById(id);
        if(newProduct == null) {
            throw new ProductNotFound("No such product found");
        }
        return productRepository.save(product);
    }
    public Product replaceProduct(long id, Product product) throws ProductNotFound {
        Product replacedProduct = productRepository.findById(id);
        if(replacedProduct == null) {
            throw new ProductNotFound("No such product found");
        }
        if(product.getTitle() != null) {
            replacedProduct.setTitle(product.getTitle());
        }
        if(product.getDescription() != null) {
            replacedProduct.setDescription(product.getDescription());
        }
        if(product.getPrice() != 0.0){
            replacedProduct.setPrice(product.getPrice());
        }
        if(product.getCategory() != null) {
            replacedProduct.setCategory(product.getCategory());
        }
        return productRepository.save(replacedProduct);
    }
    @Override
    public void deleteProduct(long id) {

    }

}
