package cn.tcmp.six.service;

import cn.tcmp.six.entity.Project;
import cn.tcmp.six.util.WyjPageUtils;

import java.util.List;

public interface WyjProjectService {

    //项目统计( 1.项目名称的展示(按项目名查询))
    List<Project> queryAllProjectName(String projectName);
    //项目统计(2.按项目名查详情)
    Project queryAllProjectid(Integer id);





}
