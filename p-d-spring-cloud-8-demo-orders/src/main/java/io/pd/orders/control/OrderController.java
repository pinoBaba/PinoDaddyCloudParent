package io.pd.orders.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {

    //注入端口 以此响应区别
    @Value("${server.port}")
    private int port;

    //@GetMapping
    public String rest(){
        System.out.println("success into ORDERS");
        return "ORDERS's response";
    }
    @GetMapping
    public String rest2(){
        System.out.println("success into ORDERS");
        return "ORDERS's response , 机器端口："+port;
    }

}
