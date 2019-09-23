package cn.tcmp.six.service;

import cn.tcmp.six.dao.YmyModelMapper;
import cn.tcmp.six.entity.Bug;
import cn.tcmp.six.entity.Module;
import cn.tcmp.six.entity.Task;
import cn.tcmp.six.util.WyjPageUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class YmyModelServiceImpl implements  YmyModelService {
    @Autowired
    private YmyModelMapper mapper;
    @Override
    public WyjPageUtils<Module> detialByUserid(Integer id,Integer pageNum,Integer pageNo) {
        PageHelper.startPage(pageNo,pageNum);
        List<Module> list=mapper.detailByUserid(id);
        PageInfo<Module> info=new PageInfo<>(list);
        WyjPageUtils<Module> util=new WyjPageUtils<>();
        util.setList(info.getList());
        util.setPageNo(info.getPageNum());
        util.setPageSize(info.getPageSize());
        util.setTotalPageCount(info.getPages());
        return util;
    }

    @Override
    public Integer agree(Integer id) {
        return mapper.agree(id);
    }

    @Override
    public Integer Shenqing(Integer id) {
        return mapper.Shenqing(id);
    }

    @Override
    public WyjPageUtils<Task> queryTask(Integer id, Integer pageSize, Integer pageNo) {
        PageHelper.startPage(pageNo,pageSize);
        List<Task> list=mapper.detailByModulId(id);
        PageInfo info=new PageInfo(list);
        WyjPageUtils<Task> util=new WyjPageUtils<>();
        util.setTotalPageCount(info.getPages());
        util.setPageSize(info.getPageSize());
        util.setPageNo(info.getPageNum());
        util.setList(info.getList());

        return util;
    }

    @Override
    public List<Module> queryAllModule(Integer id) {
        return mapper.detailByUserid(id);
    }

    @Override
    public Integer updateTask(Integer id) {
        return mapper.updateTask(id);
    }

    @Override
    public Integer addBug(Bug bug) {
        return mapper.addBug(bug);
    }

    @Override
    public WyjPageUtils<Bug> queryBug(Integer userid, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Bug> list=mapper.queryBug(userid);
        PageInfo<Bug> info=new PageInfo<>(list);
        WyjPageUtils<Bug> util=new WyjPageUtils<>();
        util.setList(info.getList());
        util.setPageNo(info.getPageNum());
        util.setPageSize(info.getPageSize());
        util.setTotalPageCount(info.getPages());


        return util;
    }

    @Override
    public Integer updateBugOk(Integer id) {
        return mapper.updateBugOk(id);
    }

    @Override
    public Integer updateBugNo(Integer id) {
        return mapper.updateBugNo(id);
    }

    @Override
    public Integer updatetask(Integer id) {
        return mapper.updateTask(id);
    }


}
