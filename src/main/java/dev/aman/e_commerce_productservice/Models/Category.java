package dev.aman.e_commerce_productservice.Models;

//import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String title;
    private String description;
    @OneToMany
    private List<Product> products;

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public List<Product> getProducts(){
        return products;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setProducts(List<Product> products){
        this.products = products;
    }
}


