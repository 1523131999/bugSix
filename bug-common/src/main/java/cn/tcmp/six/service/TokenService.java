package cn.tcmp.six.service;


import cn.tcmp.six.dto.TokenDto;
import cn.tcmp.six.entity.User;

/**
 * Created by Administrator on 2019/8/26/026.
 */
public interface TokenService {

    //生成Token
    String createToken(String userAgent, User user);
    //保存Token
    Integer saveToken(String token, User user);
    //验证Token
    Boolean checkToken(String token, String userAgent);

    //退出
    TokenDto logout(String token, String userAgent);
}
