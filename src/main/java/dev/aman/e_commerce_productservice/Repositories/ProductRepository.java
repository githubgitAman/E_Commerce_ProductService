package dev.aman.e_commerce_productservice.Repositories;

import dev.aman.e_commerce_productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
     Product findById(long id);
     List<Product> findAll();
     Product save(Product product);
     void deleteById(long id);
}
