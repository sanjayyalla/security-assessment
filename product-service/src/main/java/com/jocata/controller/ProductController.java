package com.jocata.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping("/add")
    public String addProduct(){
        return "Product added successfully";
    }

    @GetMapping("/get")
    public String getProduct(@RequestParam String id){
        return "Product "+id;
    }

    @GetMapping("/getAll")
    public String getAllProducts(){
        return "All products";
    }


    @DeleteMapping ("/delete")
    public String deleteProduct(@RequestParam String id){
        return "Product deleted with id "+id;
    }
}
