package io.pd.users.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 管理spring注入的bean
 */
@Configuration
public class BeanConfig {

    /**
     * 注入RestTemplate由spring管理
     *
     * LoadBalanced使RestTemplate对象具备负载均衡能力再请求(本质是由ribbon做完负载均衡再返回的节点给rest做请求)
     */
    @LoadBalanced
    @Bean
    public RestTemplate getRestInstance(){
        return new RestTemplate();
    }

}
