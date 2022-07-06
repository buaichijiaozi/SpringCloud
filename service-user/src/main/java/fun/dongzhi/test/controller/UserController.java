package fun.dongzhi.test.controller;

import fun.dongzhi.test.entity.User;
import fun.dongzhi.test.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService service;

    //这里以RESTFul风格为例
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid){
        System.out.println("welcome to user service");
        return service.getUserById(uid);
    }
}
