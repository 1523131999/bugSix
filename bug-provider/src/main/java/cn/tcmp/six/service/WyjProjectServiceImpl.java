package cn.tcmp.six.service;

import cn.tcmp.six.dao.WyjProjectMapper;
import cn.tcmp.six.entity.Project;

import cn.tcmp.six.entity.State;
import cn.tcmp.six.entity.Task;
import cn.tcmp.six.util.WyjPageUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class WyjProjectServiceImpl implements WyjProjectService {
    @Autowired
    private WyjProjectMapper wyjProjectMapper;

    @Override
    public List<Project> queryAllProjectName(String projectName) {
        return wyjProjectMapper.queryAllProjectName(projectName);
    }

    @Override
    public List<Task> queryAllProjectid(Integer projectid) {
        return wyjProjectMapper.queryAllProjectid(projectid);
    }

    @Override
    public List<Project> queryAllProjectState(Integer isstate) {
        return wyjProjectMapper.queryAllProjectState(isstate);
    }

    @Override
    public WyjPageUtils<Task> queryAllTask(Integer assign, Integer pageNum, Integer pageNo) {
        PageHelper.startPage(pageNo,pageNum);
        List<Task> list=wyjProjectMapper.queryAllTask(assign);
        PageInfo<Task> info=new PageInfo<>(list);
        WyjPageUtils<Task> util=new WyjPageUtils<>();
        util.setList(info.getList());
        util.setPageNo(info.getPageNum());
        util.setPageSize(info.getPageSize());
        util.setTotalPageCount(info.getPages());
        return util;
    }

    @Override
    public Integer queryAllCount(Integer id) {
        return wyjProjectMapper.queryAllCount(id);
    }

    @Override
    public Integer saveProject(Project project) {
        return wyjProjectMapper.saveProject(project);
    }

    @Override
    public Integer updateTask(Task task) {
        return wyjProjectMapper.updateTask(task);
    }

    @Override
    public Task queryTaskById(Integer id) {
        return wyjProjectMapper.queryTaskById(id);
    }

    @Override
    public Integer deleteTask(Integer id) {
        return wyjProjectMapper.deleteTask(id);
    }


}
