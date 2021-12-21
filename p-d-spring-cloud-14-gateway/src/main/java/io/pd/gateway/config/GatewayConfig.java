package io.pd.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 网关配置信息 ， 谨记 以java对象配置信息优先级高于配置文件 see in:https://docs.spring.io/spring-cloud-gateway/docs/2.2.7.RELEASE/reference/html/#the-weight-route-predicate-factory 5.11.1
 * @author: PinoDaddy
 * @date: 2021/12/21
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                //匹配配置文件routes_category的内容，验证优先级
                .route("routes_category",r -> r.path("/category").uri("http://localhost:8008"))


                .build();
    }

}
