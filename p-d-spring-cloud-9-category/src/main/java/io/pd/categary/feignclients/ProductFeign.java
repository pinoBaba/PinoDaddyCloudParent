package io.pd.categary.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description product服务请求客户端
 * @author: PinoDaddy
 * @date: 2021/11/1
 */
@FeignClient("PRODUCT")
public interface ProductFeign {

    @GetMapping("product/list")
    String showProductList();

}
