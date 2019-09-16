package cn.tcmp.six.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GpsModelController {

    @RequestMapping("toGpsHome")
    public  String toGpsHome() {
        return "GpsHome";
    }

    @RequestMapping("toRenWu")
    public  String toRenWu(){
        return  "gpsrenwu";
    }


}
