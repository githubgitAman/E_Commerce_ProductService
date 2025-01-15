package dev.aman.e_commerce_productservice.AuthenticationCommons;

import dev.aman.e_commerce_productservice.DTOs.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationComm {
    RestTemplate restTemplate;
    public AuthenticationComm(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public UserDTO validateToken(String token){
        return restTemplate.getForObject("http://localhost:4141/users/validate/" + token,
                UserDTO.class);
       }
}

