package fun.dongzhi.test.service.impl;

import fun.dongzhi.test.entity.User;
import fun.dongzhi.test.mapper.UserMapper;
import fun.dongzhi.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;

    @Override
    public User getUserById(Integer uid) {
        return mapper.getUserById(uid);
    }
}
