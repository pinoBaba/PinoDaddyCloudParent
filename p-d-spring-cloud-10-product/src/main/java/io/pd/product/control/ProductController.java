package io.pd.product.control;

import io.pd.product.entity.productVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    /**
     * 定义响应数据以对象传递
     */
    @GetMapping("response/entity")
    public productVO getProductById( Integer id ){
        System.out.println( "id:"+id );
        return new productVO("1","黑丝", new Date());
    }

    //定义响应数据以Map包含实体对象集
    @GetMapping("response/map/{categoryId}/{currentPage}/{pageSize}")
    public Map<String,Object> getProductsPyPage( @PathVariable("categoryId") int categoryId ,@PathVariable("currentPage") int currentPage ,@PathVariable("pageSize") int pageSize  ){

        System.out.println("请求参数:"+ categoryId + currentPage + pageSize);

        //响应集合中，应包含当前页 总条数  和实际对象数据
        Map<String,Object> result = new HashMap<String ,Object>();
        result.put( "currentPage" , 17L);
        result.put( "count", 999999L);

        List<productVO> products = new ArrayList<>();
        products.add(new productVO("1","黑丝",new Date()));
        products.add(new productVO("2","白丝",new Date()));
        products.add(new productVO("3","彩丝",new Date()));

        result.put( "products" ,products);
        return result;
    }

    //定义响应数据以List包含实体对象集
    @GetMapping("response/list")
    public List<productVO> getProductsByTypeid( int typeId ){
        System.out.println(" typeid :" + typeId);

        List<productVO> products = new ArrayList<>();
        products.add(new productVO("4","黑丝",new Date()));
        products.add(new productVO("5","黑丝",new Date()));
        products.add(new productVO("6","还tm是黑丝",new Date()));
        return products;
    }



}
