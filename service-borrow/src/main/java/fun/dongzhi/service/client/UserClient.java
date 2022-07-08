package fun.dongzhi.service.client;

import fun.dongzhi.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient("userservice")
//fallback参数指定为我们刚刚编写的实现类
@FeignClient(value = "userservice", fallback = UserFallbackClient.class)
public interface UserClient {

    //路径保证和其他微服务提供的一致即可
    @RequestMapping("/user/{uid}")
    User findUserById(@PathVariable("uid") Integer uid);  //参数和返回值也保持一致
}
