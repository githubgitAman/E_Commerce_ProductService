package dev.aman.e_commerce_productservice.Repositories;

import dev.aman.e_commerce_productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
     Product findById(long id);
     List<Product> findAll();
     Product save(Product product);
     void deleteById(long id);
}
