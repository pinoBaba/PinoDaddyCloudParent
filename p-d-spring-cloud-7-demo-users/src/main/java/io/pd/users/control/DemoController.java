package io.pd.users.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/* spring提供的发起rest请求的能力，与SpringCloud无关 */
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("users")
public class DemoController {

    @GetMapping
    public String rest(){
        System.out.println("success into users");
        return "users's response";
    }

    @GetMapping("call/orders")
    public String invokeOrdersService(){
        System.out.println("Start to invoke order ");

        RestTemplate restTemplate = new RestTemplate();
        final String result = restTemplate.getForObject("http://localhost:8006/orders", String.class);
        System.out.println("end to invoke order ,please see result: "+result);

        return "users call success";
    }

}
