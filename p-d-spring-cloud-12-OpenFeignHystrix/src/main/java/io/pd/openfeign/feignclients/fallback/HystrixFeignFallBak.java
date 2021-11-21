package io.pd.openfeign.feignclients.fallback;

import io.pd.openfeign.feignclients.HystrixFeignClient;
import org.springframework.context.annotation.Configuration;

/**
 * feignClients的错误回调，重写的方法针对其调用接口出现错误的回调
 */
@Configuration
public class HystrixFeignFallBak implements HystrixFeignClient {
    @Override
    public String test0(Integer id) {
        return "this is HystrixFeignClients' fallback page. cause request hystrix-demo failed";
    }
}
