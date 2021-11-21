package io.pd.openfeign;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * openFeign 和 hystrix 整合
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class FeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixApplication.class,args);
    }
}
