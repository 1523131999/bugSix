package cn.tcmp.six.service;


import cn.tcmp.six.dao.TTUserMapper;
import cn.tcmp.six.entity.User;
import cn.tcmp.six.util.WyjPageUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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


    @Override
    public WyjPageUtils<User> queryAll(User user, Integer pageNum, Integer pageNo) {
       PageHelper.startPage(pageNo,pageNum);
        List<User> list=userMapper.queryAll(user);
        PageInfo<User> info=new PageInfo<>(list);
        WyjPageUtils<User> util=new WyjPageUtils<>();
        util.setList(info.getList());
        util.setPageNo(info.getPageNum());
        util.setPageSize(info.getPageSize());
        util.setTotalPageCount(info.getPages());
        return util;
    }

    @Override
    public WyjPageUtils<User> detailByUserid(Integer id, Integer pageNum, Integer pageNo) {
        PageHelper.startPage(pageNo,pageNum);
        List<User> list=userMapper.detailByUserid(id);
        PageInfo<User> info=new PageInfo<>(list);
        WyjPageUtils<User> util=new WyjPageUtils<>();
        util.setList(info.getList());
        util.setPageNo(info.getPageNum());
        util.setPageSize(info.getPageSize());
        util.setTotalPageCount(info.getPages());
        return util;
    }

    @Override
    public Integer add(User user) {
        return userMapper.add(user);
    }

    @Override
    public Integer delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public WyjPageUtils<User> queryAllBy(User user, Integer pageNum, Integer pageNo) {
        PageHelper.startPage(pageNo,pageNum);
        List<User> list=userMapper.queryAllBy(user);
        PageInfo<User> info=new PageInfo<>(list);
        WyjPageUtils<User> util=new WyjPageUtils<>();
        util.setList(info.getList());
        util.setPageNo(info.getPageNum());
        util.setPageSize(info.getPageSize());
        util.setTotalPageCount(info.getPages());
        return util;
    }


}
