package io.pd.categary.feignclients;

import io.pd.categary.feignclients.entity.productVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description product服务请求客户端
 * @author: PinoDaddy
 * @date: 2021/11/1
 */
@FeignClient("PRODUCT/product")
public interface ProductFeign {

    @GetMapping("/list")
    String showProductList();

    @GetMapping("args/scattered")
    String showArgs0(@RequestParam("id") String id,@RequestParam("name")  String name );

    @GetMapping("args/scattered/{id}/{name}")
    String showArgs(@PathVariable("id") String id, @PathVariable("name")  String name );

    @PostMapping("args/body")
    String showArgs1(@RequestBody productVO productVO );

}
