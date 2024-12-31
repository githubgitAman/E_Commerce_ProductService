package dev.aman.e_commerce_productservice.Models;

//import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private double price;
    private String description;
    @ManyToOne
    private Category category;

    public String getTitle(){
        return title;
    }
    public double getPrice(){
        return price;
    }
    public Category getCategory(){
        return category;
    }
    public String getDescription(){
        return description;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
