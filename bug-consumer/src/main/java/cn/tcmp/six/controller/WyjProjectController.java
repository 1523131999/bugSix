package cn.tcmp.six.controller;

import cn.tcmp.six.entity.Project;
import cn.tcmp.six.entity.Task;
import cn.tcmp.six.service.WyjProjectService;
import cn.tcmp.six.util.WyjPageUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("project")
public class WyjProjectController {


    @Reference
    private WyjProjectService wyjProjectService;


    @RequestMapping("/")
    public String project() {
        return "index";
    }

    //项目名称展示
    @RequestMapping(value = "queryAllProjectName", method = RequestMethod.GET)
    public String queryAllProjectName(String projectName, Model model) {
        model.addAttribute("projectName", wyjProjectService.queryAllProjectName(projectName));
        System.err.println("++++++++++++++++++++++++++++>>>>>>>>>>>>>>>>+====================" + projectName);
        return "project_list";
    }

    //id
    @RequestMapping("queryAllProjectid")
    public String queryAllProjectid(Integer projectid, Model model) {
        model.addAttribute("projectid", wyjProjectService.queryAllProjectid(projectid));
        return "redirect:/project/queryAllProjectName";

    }

    //任务列表
    @RequestMapping("toRenWuAll")
    public String toRenWu(Integer assign, Integer pageNum, Integer pageNo, Model model) {
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageNum == null) {
            pageNum = 3;
        }
        assign = 3;
        model.addAttribute("list", wyjProjectService.queryAllTask(assign, pageNum, pageNo));
        model.addAttribute("userid", assign);
        return "project_detail";
    }
    //去添加项目(项目)
    @RequestMapping("toAdd")
    public String toAddProject() {
        return "project_add_xm";
    }
    //save添加项目(项目)
    @ResponseBody
    @RequestMapping(value = "saveProject",method = RequestMethod.POST)
    public Map<String,String> addFlower(Project project){
        Integer count= wyjProjectService.saveProject(project);
        System.out.println("+================>>>>>>>>>>"+count);
        System.err.println(">>>>>>>>>>>>>>>>>"+project);
        Map<String,String> map=new HashMap<>();
        if(count>0){
            System.out.println("+================>>>>>>>>>>"+count);
            map.put("msg","ok");
            System.out.println("==========>>>>>>>>>>>>>>>>>>>>>===========>>>>>"+map);
            return map;
        }
        map.put("msg","error");
        return map;
    }

    //删除
    @RequestMapping("deleteTaskId")
    public String deleteTaskId(Integer id){

        wyjProjectService.deleteTask(id);
        return "redirect:/project/toRenWuAll";
    }

    //编辑任务
    @RequestMapping(value = "toBJ",method = RequestMethod.GET)
    public String toBJ(Integer id,Model model) {
        Task task=wyjProjectService.queryTaskById(id);
        model.addAttribute("list",task);
        System.out.println("+++++++++++++++++++>>>>>>>>>>>>>>>>>>>>>>"+task);
        return "project_bj";
    }
    //做编辑任务
    @ResponseBody
    @RequestMapping("updateTaskR")
    public  String updateTaskR(Task task){
        System.out.println("+++++++++++++++++++>>>>>>>>>>>>>>>>>>>>>>"+task);
        return wyjProjectService.updateTask(task)>0? "ok":"error";
    }


    //项目总数
    @RequestMapping(value = "queryCount",method = RequestMethod.GET)
    public String queryAllCount(Integer id,Model model){

        System.out.println("+++++++++++++++++++++++++?????????????????????????????????+++++++++++++++"+id);
        Integer project=wyjProjectService.queryAllCount(id);
        model.addAttribute("project",project);
        System.out.println("+++++++++++++++++++++++++?????????????????????????????????+++++++++++++++"+project);
        return "project_list";
    }




}
