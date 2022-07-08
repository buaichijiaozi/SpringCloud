package fun.dongzhi.service.impl;

import fun.dongzhi.entity.User;
import fun.dongzhi.mapper.UserMapper;
import fun.dongzhi.service.UserService;
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
