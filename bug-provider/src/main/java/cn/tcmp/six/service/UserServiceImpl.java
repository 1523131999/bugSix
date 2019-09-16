package cn.tcmp.six.service;


import cn.tcmp.six.dao.TTUserMapper;
import cn.tcmp.six.entity.User;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2019/8/26/026.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TTUserMapper userMapper;

    public User login(User user) {
        return userMapper.login(user);

    }
}
