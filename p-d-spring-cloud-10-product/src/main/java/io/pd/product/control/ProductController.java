package io.pd.product.control;

import io.pd.product.entity.productVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 产品服务，提供产品信息接口
 * @author: PinoDaddy
 * @date: 2021/11/1
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Value("${server.port}")
    private int port;

    @GetMapping
    public String healthy(){
        return "product service is ready,and support port is "+port;
    }

    class Product{
        private String id;
        private String name;
        private String type;
        private String price;
        public Product(){
            id = "1";
            name="🚗";
            type="小汽车";
            price="50w";
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Product{");
            sb.append("id='").append(id).append('\'');
            sb.append(", name='").append(name).append('\'');
            sb.append(", type='").append(type).append('\'');
            sb.append(", price='").append(price).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
    @GetMapping("list")
    public String list(){
        return "product service show the list:"+ new Product().toString() + " \n and this port is "+port;
    }

    /**
     * 以零散的参数传递
     */
    @GetMapping("args/scattered")
    public String showArgs0(String id, String name  ){
        System.out.println( "请求参数:"+id + name   );
        return "show product success,port :"+ port;
    }

    /**
     * 以路径的参数传递
     */
    @GetMapping("args/scattered/{id}/{name}")
    public String showArgs(@PathVariable("id")  String id,@PathVariable("name") String name  ){
        System.out.println( "请求参数:"+id + name   );
        return "show args-path success,port :"+ port;
    }

    /**
        以对象传递参数
     */
    @PostMapping("args/body")
    public String showArgs1(@RequestBody productVO P){
        System.out.println( "请求参数:"+P  );
        return "show ARGS1 success,port :"+ port;
    }

    /**
     * 定义以数组传递参数
     */
    @GetMapping("args/array")
    public String showArgs4( String[] ids ){
        for (String id : ids)   System.out.println(id);

        return "SHOW ARGS4 success,port :"+ port;
    }

    /**
     * 定义以集合List传递参数
     * 谨记 MVC不支持直接以list集合方式传递参数，需以对象存储集合传输
     */
    @GetMapping("args/list")
    public String showArgs5( productVO productVO ){

        productVO.getIds().forEach(id->{
            System.out.println(id);
        });
        return "SHOW ARGS5 SUCCESS,port :"+ port;
    }

}
