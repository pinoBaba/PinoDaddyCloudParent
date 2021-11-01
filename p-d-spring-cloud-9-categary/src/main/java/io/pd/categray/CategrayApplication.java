package io.pd.categray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description 类别服务启动类
 * @author: PinoDaddy
 * @date: 2021/11/1
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CategrayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategrayApplication.class,args);
    }
}
