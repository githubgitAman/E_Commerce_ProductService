package dev.aman.e_commerce_productservice.DTOs;

import dev.aman.e_commerce_productservice.Models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductServiceDtos {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;

    public void setId(long id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public double getPrice(){
        return price;
    }
    public String getCategory(){
        return category;
    }
    public String getDescription(){
        return description;
    }
}