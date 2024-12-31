package dev.aman.e_commerce_productservice.Services;

import dev.aman.e_commerce_productservice.DTOs.FakeStoreProductServiceDtos;
import dev.aman.e_commerce_productservice.Exceptions.ProductNotFound;
import dev.aman.e_commerce_productservice.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFound {
        FakeStoreProductServiceDtos fakeStoreProductServiceDtos = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductServiceDtos.class);
        if(fakeStoreProductServiceDtos == null)
            throw new ProductNotFound("Product with given " + id + "not found");
        return convertFakeStoreProductDtoToProduct(fakeStoreProductServiceDtos);
    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFound{
        FakeStoreProductServiceDtos[] fakeStoreProductServiceDtos1 =
                restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductServiceDtos[].class);
        if(fakeStoreProductServiceDtos1 == null)
            throw new ProductNotFound("Product with given not found");
        List<Product> list = new ArrayList<>();
        for(FakeStoreProductServiceDtos fakeStoreProductServiceDtos : fakeStoreProductServiceDtos1)
            list.add(convertFakeStoreProductDtoToProduct(fakeStoreProductServiceDtos));
        return list;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(long id, Product product) throws ProductNotFound {
        return null;
    }

    @Override
    public Product replaceProduct(long id, Product product) throws ProductNotFound {
        return null;
    }

    @Override
    public void deleteProduct(long id) throws ProductNotFound {

    }

    public Product convertFakeStoreProductDtoToProduct(FakeStoreProductServiceDtos fakeStoreProductServiceDtos) {
        Product product = new Product();
        product.setId(fakeStoreProductServiceDtos.getId());
        product.setTitle(fakeStoreProductServiceDtos.getTitle());
        product.setDescription(fakeStoreProductServiceDtos.getDescription());
        product.setPrice(fakeStoreProductServiceDtos.getPrice());
        return product;
    }
}
