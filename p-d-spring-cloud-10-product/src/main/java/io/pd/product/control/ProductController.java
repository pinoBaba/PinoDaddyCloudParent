package io.pd.product.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
