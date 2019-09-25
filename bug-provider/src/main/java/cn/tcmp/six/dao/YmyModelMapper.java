package cn.tcmp.six.dao;

import cn.tcmp.six.entity.Module;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface YmyModelMapper {

    List<Module> detailByUserid(Integer id);
    @Update("update module set isagreen =1 where id=#{id}")
    Integer agree(Integer id);
    @Update("update module set isagreen=2 where id=#{id}")
    Integer Shenqing(Integer id);

    List<Task> detailByModulId(Integer id);
    @Update("update task set isEnd=2 where id=#{id}")
    Integer updateTask(Integer id);

    Integer addBug(Bug bug);
    @Select("select * from bug where userid=#{userid} and statu=1")
    List<Bug> queryBug(Integer userid);
    @Update("update bug set statu=2 where id=#{id}")
    Integer updateBugOk(Integer id);
    @Update("update bug set statu=0 where id=#{id}")
    Integer updateBugNo(Integer id);
    @Update("update task set isEnd=0 where id=id")
    Integer updatetask(Integer id);

}
