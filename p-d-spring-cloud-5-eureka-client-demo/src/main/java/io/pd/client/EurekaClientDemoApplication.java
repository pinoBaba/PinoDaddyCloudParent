package io.pd.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description TODO
 * @author: PinoDaddy
 * @date: 2021/10/19
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientDemoApplication.class,args);
    }
}
