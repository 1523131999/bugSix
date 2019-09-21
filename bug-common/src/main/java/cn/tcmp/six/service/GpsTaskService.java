package cn.tcmp.six.service;

import cn.tcmp.six.entity.Task;

import java.util.List;

public interface GpsTaskService {

    List<Task> queryAllTask(Integer assign);

}
