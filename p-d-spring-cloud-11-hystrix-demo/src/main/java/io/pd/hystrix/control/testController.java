package io.pd.hystrix.control;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 测试断路器在提供方的熔断功能
 * @author: PinoDaddy
 * @date: 2021/11/12
 */
@RestController
@RequestMapping("hystrix/test")
public class testController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    //添加熔断之后的快速响应处理
    @HystrixCommand( fallbackMethod = "test0FallBack") //指定当前当前类中的某个方法作为熔断后的处理
    @GetMapping
    public String test0( Integer id ){

        if( id<0 )  throw new RuntimeException("非法参数id:"+id);
        log.info("完成参数校验");

        return "testController#test0 method invoked success;";
    }

    /**
     * 为当前test0指定的回调函数
     * @param id 实际函数的入参
     * @param t 实际函数出现的异常信息   Throwable tThrowable tThrowable tThrowable tThrowable t
     */
    private String test0FallBack(Integer id , Throwable t) {
        log.error("异常位置{{}},异常类型{{}},异常信息{{}}",t.getStackTrace()[0],t.toString(),t.getMessage());
        return "当前服务已熔断，当前操作失败的id:" + id;
    }

    //指定默认的失败回调
    @HystrixCommand( defaultFallback = "defaultFallBack")
    @GetMapping("1")
    public String test1( Integer id ){

        //id 为 null 回吞掉异常唉
        if( id<0 )  throw new RuntimeException("非法参数id:"+id);
        if( id==0 )  {  int i=10/0; }
        log.info("完成参数校验");

        return "testController#test1 method invoked success;";

    }

    /**
     * 指定默认的回调函数，需要具有通用性，所有方法均可兼容其入参，回参
     * @param t 实际函数出现的异常信息
     */
    private String defaultFallBack( Throwable t){
        log.error("异常位置{{}},异常类型{{}},异常信息{{}}",t.getStackTrace()[0],t.toString(),t.getMessage());
        return "调用当前服务失败的默认回参";
    }


}
