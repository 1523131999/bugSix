package cn.tcmp.six.service;


import cn.tcmp.six.entity.User;
import cn.tcmp.six.entity.User;
import cn.tcmp.six.util.WyjPageUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/8/26/026.
 */
public interface UserService {

    //登录
    User login(User user);

    //用户查询（分页）
    WyjPageUtils<User> queryAll(User user, Integer pageNum, Integer pageNo);

    //单个查询
    WyjPageUtils<User> detailByUserid(Integer id,Integer pageNum, Integer pageNo);

    //新增用户
    Integer add(User user);

    //删除用户
    Integer delete(Integer id);

    //高级查询
    WyjPageUtils<User> queryAllBy(User user, Integer pageNum, Integer pageNo);
}
