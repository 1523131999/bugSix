package cn.tcmp.six.service;

import cn.tcmp.six.entity.Bug;
import cn.tcmp.six.entity.Module;

import cn.tcmp.six.entity.Task;
import cn.tcmp.six.util.WyjPageUtils;

import java.util.List;

public interface  YmyModelService {

    WyjPageUtils<Module> detialByUserid(Integer id, Integer pageNum, Integer pageNo);

    Integer agree(Integer id);

    Integer Shenqing(Integer id);

    WyjPageUtils<Task> queryTask(Integer id, Integer pageSize, Integer pageNo);

    List<Module> queryAllModule(Integer id);
    Integer updateTask(Integer id);
    Integer addBug(Bug bug);
    WyjPageUtils<Bug> queryBug(Integer userid, Integer pageNo, Integer pageSize);
    Integer updateBugOk(Integer id);
    Integer updateBugNo(Integer id);
    Integer updatetask(Integer id);

}
