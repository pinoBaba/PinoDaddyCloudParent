package io.pd.categary.control;

import io.pd.categary.feignclients.ProductFeign;
import io.pd.categary.feignclients.entity.productVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description 种类服务，调用产品服务的信息
 * @author: PinoDaddy
 * @date: 2021/11/1
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    public CategoryController(ProductFeign f){
        this.productFeign = f;
    }


    @Value("${server.port}")
    private int port;
    @GetMapping
    public String healthy(){
        return "CATEGORY service IS ready,AND support PORT is "+port;
    }

    private ProductFeign productFeign;

    @GetMapping("call/product/list")
    public String showProductList(){
        final Object o = productFeign.showProductList();
        return "CATEGORY service IS ready,AND support PORT is "+port
                +"\n*********************************\n"+
                ",CALLBACK :"+o;
    }

    @GetMapping("call/product/args/scattered")
    public String test0(){
        final String res = productFeign.showArgs0("3s0b6l", "汽车");

        System.out.println(res);

        return "category service ok,see detail in console";
    }
    @GetMapping("call/product/args/scattered/path")
    public String test(){
        final String res = productFeign.showArgs("3", "jk");

        System.out.println(res);

        return "category service ok,see detail in console";
    }
    @GetMapping("call/product/args/body")
    public String test1(){
        final String res = productFeign.showArgs1(new productVO("1","黑丝",new Date()));

        System.out.println(res);

        return "category service ok,see detail in console";
    }

    @GetMapping("call/product/args/array")
    public String test4(){
        final String res = productFeign.showArgs4( new String[]{"33","11","1","2"} );

        System.out.println(res);

        return "request test4 ok see more in console";
    }

    @GetMapping("call/product/args/list")
    public String test5(){
        final String res = productFeign.showArgs4( new String[]{"af1","wx1","ns0","09f3b"} );

        System.out.println(res);

        return "request test4 ok see more in console";
    }
}
