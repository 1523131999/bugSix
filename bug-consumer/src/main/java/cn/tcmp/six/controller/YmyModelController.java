package cn.tcmp.six.controller;

import cn.tcmp.six.service.YmyModelService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YmyModelController {
        @Reference
        private YmyModelService service;

    @RequestMapping("detailById")
    public String detail(Integer id, Integer pageNum, Integer pageNo, Model model) {
        model.addAttribute("util",service.detialByUserid(id,pageNum,pageNo));
        return  "all";
    }
    @RequestMapping("/")
    public  String toWelcome() {
        return "welcome";
    }

}
