package io.pd.categary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description 类别服务启动类
 * @author: PinoDaddy
 * @date: 2021/11/1
 */
@SpringBootApplication
@EnableDiscoveryClient
//启用openfeign
@EnableFeignClients
public class CategaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategaryApplication.class,args);
    }
}
