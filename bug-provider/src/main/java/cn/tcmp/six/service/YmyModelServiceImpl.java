package cn.tcmp.six.service;

import cn.tcmp.six.dao.YmyModelMapper;
import cn.tcmp.six.entity.Module;
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
        PageHelper.startPage(pageNum,pageNo);
        List<Module> list=mapper.detailByUserid(id);
        PageInfo<Module> info=new PageInfo<>(list);
        WyjPageUtils<Module> util=new WyjPageUtils<>();
        util.setList(info.getList());
        util.setPageNo(info.getPageNum());
        util.setPageSize(info.getPageSize());

        return util;
    }
}
