package cn.tcmp.six.dao;

import cn.tcmp.six.entity.Task;

import java.util.List;

public interface GpsTaskMapper {
    List<Task> queryAllTask(Integer assign);
}
