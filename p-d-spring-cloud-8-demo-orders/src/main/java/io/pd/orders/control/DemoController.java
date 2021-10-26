package io.pd.orders.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class DemoController {

    @GetMapping
    public String rest(){
        System.out.println("success into ORDERS");
        return "ORDERS's response";
    }

}
