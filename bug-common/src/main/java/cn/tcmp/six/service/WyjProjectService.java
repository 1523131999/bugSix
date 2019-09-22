package cn.tcmp.six.service;

import cn.tcmp.six.entity.Project;
import cn.tcmp.six.entity.State;
import cn.tcmp.six.entity.Task;
import cn.tcmp.six.util.WyjPageUtils;

import java.util.List;

public interface WyjProjectService {

    //项目统计( 1.项目名称的展示(按项目名查询))
    List<Project> queryAllProjectName(String projectName);
    //项目统计(2.按项目名查详情)
    List<Task> queryAllProjectid(Integer projectid);
    //进行中项目查询
    List<Project> queryAllProjectState(Integer isstate);
    //任务列表
    WyjPageUtils<Task> queryAllTask(Integer assign,Integer pageNum, Integer pageNo);



}
