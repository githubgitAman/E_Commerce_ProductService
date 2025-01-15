package dev.aman.e_commerce_productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Roles {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
