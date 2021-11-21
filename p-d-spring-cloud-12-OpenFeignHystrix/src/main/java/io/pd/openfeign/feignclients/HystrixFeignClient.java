package io.pd.openfeign.feignclients;


import io.pd.openfeign.feignclients.fallback.HystrixFeignFallBak;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "HYSTRIX" , fallback = HystrixFeignFallBak.class)
public interface HystrixFeignClient {

    //请求HystrixDemo的测试方法
    @GetMapping("hystrix/test/2")
    String test0( @RequestParam("id") Integer id);

}
