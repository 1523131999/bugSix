package cn.tcmp.six.controller;

import cn.tcmp.six.entity.Task;
import cn.tcmp.six.service.GpsTaskService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GpsModelController {

    @Reference
    private GpsTaskService gpsTaskService;



    @RequestMapping("toGpsHome")
    public  String toGpsHome() {
        return "GpsHome";
    }

    @RequestMapping("toRenWu")
    public  String toRenWu(Integer assign,Model model){
        assign =3;
        List<Task> list=gpsTaskService.queryAllTask(assign);
        model.addAttribute("list",list);
        return  "gpsrenwu";
    }


}
