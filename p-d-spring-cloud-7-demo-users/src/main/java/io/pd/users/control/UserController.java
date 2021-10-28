package io.pd.users.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/* spring提供的发起rest请求的能力，与SpringCloud无关 */
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String rest(){
        System.out.println("success into users");
        return "users's response";
    }

    @GetMapping("call/orders/myLoadBalance")
    public String invokeOrdersService(){
        System.out.println("Start to invoke order ");

        RestTemplate restTemplate = new RestTemplate();
        final String result = restTemplate.getForObject(chooseNode()+"/orders", String.class);
        System.out.println("end to invoke order ,please see result: "+result);

        return "users call success";
    }
    /**
     * 简易负载均衡
     * @return 返回节点url
     */
    private String chooseNode(){
        //模拟存储节点信息
        List<String> nodeAddress = new ArrayList<String>();
        //添加节点
        nodeAddress.add("http://localhost:8006");
        nodeAddress.add("http://localhost:8007");

        final int i = new Random().nextInt(nodeAddress.size());

        return nodeAddress.get(i);
    }



    /**
     * 以SpringCloud提供得组件来发其rest请求
     * 1 DiscoverClient 2LoadBalanceClient  3LoadBalance
     * @return
     */
    // 1
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("call/discoveryClient/orders")
    public String invokeOrdersService2(){

        //已知请求服务为order服务 ， 入参给定order服务得id(ORDERS) ，返回服务列表集合
        final List<ServiceInstance> orders = discoveryClient.getInstances("ORDERS");
        final ServiceInstance serviceInstance = orders.get(0);

        System.out.println( serviceInstance.getHost() + serviceInstance.getPort()   );

        final String res = new RestTemplate().getForObject(serviceInstance.getUri() + "/orders", String.class);
        System.out.println(res);
        return "users call success";
    }

    // 2
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping("call/LoadBalancerClient/orders")
    public String invokeOrdersService3(){

        //LoadBalancerClient.choose() 以默认轮询方式返回服务实例
        final ServiceInstance orders = loadBalancerClient.choose("ORDERS");

        System.out.println( orders.getHost() + orders.getPort()   );

        final String res = new RestTemplate().getForObject(orders.getUri() + "/orders", String.class);
        System.out.println();
        return res;
    }


}
