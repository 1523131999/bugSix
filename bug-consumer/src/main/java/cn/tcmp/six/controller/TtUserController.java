package cn.tcmp.six.controller;


import cn.tcmp.six.dto.DataDto;
import cn.tcmp.six.dto.TokenDto;
import cn.tcmp.six.entity.User;
import cn.tcmp.six.service.TokenService;
import cn.tcmp.six.service.UserService;
import cn.tcmp.six.util.Common;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
@Controller
@RequestMapping("user")
public class TtUserController {

    @Reference
    private UserService userService;
    @Reference
    private TokenService tokenService;

    //退出
    @RequestMapping(value = "logout",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String logout(HttpServletRequest request) {
        String agent = request.getHeader("User-Agent");
        String token = request.getHeader("token");
        TokenDto tokenDto = tokenService.logout(token, agent);
        return JSON.toJSONString(tokenDto);
    }



    //用户登录
    @RequestMapping(value = "login",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String login(HttpServletRequest request, User user) {
        TokenDto tokenDto=new TokenDto();
        DataDto data=null;

        //1. 用户名密码验证
        User loginUser = userService.login(user);
        if (null == loginUser) {
            //用户名密码错误
            tokenDto.setErrorcode(Common.CODE_02);
            return JSON.toJSONString(tokenDto);
        }

        //2. 生成token
        String token=tokenService.
                createToken(request.getHeader("User-Agent"),loginUser);
        //3. 保存token
        tokenService.saveToken(token,loginUser);

        //4.将token信息返回给用户(TokenDto ->json)
        data=new DataDto();
        data.setToken(token);
        //token的生成时间
        data.setGenTime(Calendar.getInstance().getTimeInMillis()+"");
        //token的过期时间
        data.setExpTime(Calendar.getInstance().getTimeInMillis()
                +Common.TOKEN_TIMEOUT+"");
        tokenDto.setData(data);
        tokenDto.setErrorcode(Common.CODE_SUCCESS);
        return JSON.toJSONString(tokenDto);
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

}

