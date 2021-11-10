package io.pd.categary.feignclients;

import io.pd.categary.feignclients.entity.productVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description product服务请求客户端
 * @author: PinoDaddy
 * @date: 2021/11/1
 */
@FeignClient("PRODUCT")
public interface ProductFeign {

    @GetMapping("product/list")
    String showProductList();

    @GetMapping("product/args/scattered")
    String showArgs0(@RequestParam("id") String id,@RequestParam("name")  String name );

    @GetMapping("product/args/scattered/{id}/{name}")
    String showArgs(@PathVariable("id") String id, @PathVariable("name")  String name );

    @PostMapping("product/args/body")
    String showArgs1(@RequestBody productVO productVO );

    //声明以数组方式传递参数调用服务提供者方法showArgs4()
    @GetMapping("product/args/array")
    String showArgs4(@RequestParam("ids") String[] ids );

    //声明以集合List传递参数
    @GetMapping("product/args/list")
    String showArgs5(@RequestParam("ids") String[] ids );

    //声明服务提供者响应entity
    @GetMapping("product/response/entity")
    productVO getProductById(@RequestParam(value="id") Integer id );

    //声明服务提供者响应类型为map
    @GetMapping("product/response/map/{categoryId}/{currentPage}/{pageSize}")
    Map getProductsPyPage( @PathVariable("categoryId") int categoryId ,@PathVariable("currentPage") int currentPage ,@PathVariable("pageSize") int pageSize );

    //声明服务提供者响应类型为List<Entity>
    @GetMapping("product/response/list")
    List<productVO> getProductsByTypeid( @RequestParam("typeId") int typeId );

    //1s
    @PostMapping("product")
    String test0();
    //3s
    @PutMapping("product")
    String test1();
    //5s
    @DeleteMapping("product")
    String test2();
}
