package cn.tcmp.six.dao;

import cn.tcmp.six.entity.Module;

import java.util.List;

public interface YmyModelMapper {

    List<Module> detailByUserid(Integer id);
}
