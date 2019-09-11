package cn.tcmp.six.mapper;

import cn.tcmp.six.entity.Module;

import java.util.List;

public interface YmyModelMapper {

    List<Module> detailByUserid(Integer id);
}
