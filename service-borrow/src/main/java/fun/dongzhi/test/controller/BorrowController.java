package fun.dongzhi.test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import fun.dongzhi.test.entity.UserBorrowDetail;
import fun.dongzhi.test.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {

    @Resource
    private BorrowService service;

    @HystrixCommand(fallbackMethod = "onError")    //使用@HystrixCommand来指定备选方案
    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") Integer uid){
        return service.getUserBorrowDetailByUid(uid);
    }

    //备选方案，这里直接返回空列表了
    //注意参数和返回值要和上面的一致
    UserBorrowDetail onError(Integer uid){
        System.out.println("NO");
        return new UserBorrowDetail(null, Collections.emptyList());
    }
}
