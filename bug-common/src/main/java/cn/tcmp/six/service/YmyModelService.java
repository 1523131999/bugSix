package cn.tcmp.six.service;

import cn.tcmp.six.entity.Module;
import cn.tcmp.six.util.WyjPageUtils;

public interface  YmyModelService {

    WyjPageUtils<Module> detialByUserid(Integer id, Integer pageNum, Integer pageNo);

}
