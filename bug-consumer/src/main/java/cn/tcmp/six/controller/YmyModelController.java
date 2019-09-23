package cn.tcmp.six.controller;

import cn.tcmp.six.entity.Bug;
import cn.tcmp.six.service.YmyModelService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class YmyModelController {
        @Reference
        private YmyModelService service;

    @RequestMapping("detailById")
    public String detail(Integer id, Integer pageNum, Integer pageNo, Model model) {
        if (pageNo == null) {
            pageNo=1;
        }
        if (pageNum == null) {
            pageNum=3;
        }

        model.addAttribute("util",service.detialByUserid(id,pageNum,pageNo));
        model.addAttribute("userid",id);
        return  "all";
    }
    @RequestMapping("agree")
    @ResponseBody
    public Integer agree(Integer id) {
        return  service.agree(id);
    }

    @RequestMapping("shenqing")
    @ResponseBody
    public Integer shenqing(Integer id) {
        return  service.Shenqing(id);
    }

    @RequestMapping("queryTask")
    public String queryTask(Model model, Integer id,Integer pageNo) {
        if (pageNo == null) {
            pageNo=1;
        }
        Integer pageSize=3;

        model.addAttribute("util",service.queryTask(id,pageSize,pageNo));
        model.addAttribute("userid",id);

        return  "tasklist";



    }

    @RequestMapping("updateTaskS")
    @ResponseBody
    public Integer updates(Integer id) {

        return  service.updateTask(id);
    }

    @RequestMapping("queryBug")
    public String queryBug(Integer pageNo,Integer pageSize,Integer userid,Model model) {
        if (pageNo == null) {
            pageNo=1;
        }
        if (pageSize == null) {
            pageSize=3;
        }

        model.addAttribute("util",service.queryBug(userid,pageNo,pageSize));
        model.addAttribute("userid",userid);
        return "buglist";
    }

    @RequestMapping("updateBugOk")
    @ResponseBody
    public Integer updateOk(Integer id) {
        return  service.updateBugOk(id);
    }

    @RequestMapping("updateBugNo")
    @ResponseBody
    public Integer updateNo(Integer id) {
        return  service.updateBugNo(id);
    }

    @RequestMapping("addBug")

    public String addBug(Bug bug) {
        service.addBug(bug);
        service.updateTask(bug.getTaskid());
            return  "redirect:queryTask?id=2&pageNo=1";
    }

    @RequestMapping("/")
    public  String toWelcome() {
        return "index";
    }

}
