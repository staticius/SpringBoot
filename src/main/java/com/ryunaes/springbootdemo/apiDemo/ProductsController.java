package com.ryunaes.springbootdemo.apiDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @GetMapping("/product")
    public String getProducts(){
        return "Lapto121";
    }

}
