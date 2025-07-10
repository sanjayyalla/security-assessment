package com.jocata.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/create")
    public String createOrder(){
        return "Order created";
    }

    @GetMapping("/byId")
    public String getOrderbyId(@RequestParam String id){
        return "Order got with id : "+id;
    }

    @GetMapping("/all")
    public String getAllOrders(){
        return "All orders fetched successfully";
    }

    @PostMapping("/cancelOrder")
    public String cancelOrder(){
        return "Order Cancelled";
    }

}
