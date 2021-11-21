package io.pd.openfeign.control;

import io.pd.openfeign.feignclients.HystrixFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class demoController {
    public demoController(HystrixFeignClient hystrixFeignClient){
        this.hystrixFeignClient = hystrixFeignClient;
    }

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private HystrixFeignClient hystrixFeignClient;

    @GetMapping
    public String demo0(Integer id){

        log.info("print args:{}",id);
        //以openfeign通讯到hystrixdemo服务
        String s = hystrixFeignClient.test0(id);
        System.out.println(s);
        return s;

    }

}
