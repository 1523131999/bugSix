package cn.tcmp.six.service;

import cn.tcmp.six.dao.GpsTaskMapper;
import cn.tcmp.six.entity.Task;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class GpsTaskServiceImpl implements GpsTaskService  {


    @Autowired
    private GpsTaskMapper gpsTaskMapper;

    @Override
    public List<Task> queryAllTask(Integer assign) {
        return gpsTaskMapper.queryAllTask(assign);
    }
}
