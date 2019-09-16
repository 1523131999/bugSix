package cn.tcmp.six.dao;

import cn.tcmp.six.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TTUserMapper {

    //登录
        User login(User user);

    //用户查询（分页）
        List<User> queryAll(User user);
    //单个查询
        List<User> detailByUserid(Integer id);
    //新增用户
        Integer add(User user);
    //修改用户
        Integer revise(Integer id);
    //删除用户
        Integer delete(Integer id);

}
