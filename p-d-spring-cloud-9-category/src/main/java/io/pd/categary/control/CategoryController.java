package io.pd.categary.control;

import com.alibaba.fastjson.JSONObject;
import io.pd.categary.feignclients.ProductFeign;
import io.pd.categary.feignclients.entity.productVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @GetMapping("call/product/response/entity")
    public productVO test6(){

        final productVO productById = productFeign.getProductById(9);

        return productById;
    }

    @GetMapping("call/product/response/map")
    public Map test7(){

        final Map<String,Object> productsPyPage = productFeign.getProductsPyPage(8, 1, 20);

        int r1 = ( int )productsPyPage.get("currentPage");
        int r2 = ( int )productsPyPage.get("count");
        System.out.println(r1 + r2);

        /*  Object无法强转成entity  java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to io.pd.categary.feignclients.entity.productVO
            List<productVO> r3 = (List<productVO>)(productsPyPage.get("products"));
            r3.forEach(p->{
                System.out.println( p );
            });
        */

        // 错误示范 com.alibaba.fastjson.JSONException: not match : - =
        // final List<productVO> products =  JSONObject.parseArray( productsPyPage.get("products").toString() , productVO.class );

        //先序列化
        final String s = JSONObject.toJSONString(productsPyPage.get("products"));
        //再反序列化
        List<productVO> products = JSONObject.parseArray( s, productVO.class);
        products.forEach(product->{
            //需要json对象字符转对象 引入FastJson

           // final productVO productVO = JSONObject.parseObject(product.toString(), productVO.class);
            System.out.println( product );
        });



        return productsPyPage;
    }
    @GetMapping("call/product/response/list")
    public List<productVO> test8() {
        final List<productVO> productsByTypeid = productFeign.getProductsByTypeid(3);
        System.out.println("响应信息：" +productsByTypeid);
        return productsByTypeid;
    }

}
