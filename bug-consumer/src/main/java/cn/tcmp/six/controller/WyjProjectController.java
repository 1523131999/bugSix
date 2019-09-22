package cn.tcmp.six.controller;

import cn.tcmp.six.entity.Project;
import cn.tcmp.six.entity.Task;
import cn.tcmp.six.service.WyjProjectService;
import cn.tcmp.six.util.WyjPageUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
        return "project_detail";

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

    @RequestMapping("toAdd")
    public String toAdd() {

        return "project_add_xm";
    }

}
