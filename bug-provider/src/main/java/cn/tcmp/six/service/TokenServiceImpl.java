package cn.tcmp.six.service;

import cn.tcmp.six.dto.TokenDto;
import cn.tcmp.six.entity.User;
import cn.tcmp.six.util.Common;
import cn.tcmp.six.util.RedisUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/8/26/026.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String createToken(String userAgent, User user) {
        /**
         * PC 端：token:PC-USERCODE[加密]-USERID-CREATIONDATE-RONDEM[6 位]
         移动端：token: MOBILE-USERCODE[加密]-USERID-CREATIONDATE-RONDEM[6 位]
         USERCODE：登录账号
         USERID：用户表主键 ID
         CREATIONDATE：创建日期 格式：yyyyMMddHHmmsss
         RONDEM：6位随机码 userAgent MD5取6位
         expTime：过期时间
         genTime：生成时间
         */
        StringBuffer strB = new StringBuffer();
        strB.append(Common.TOKEN_PREFIX);
        //判断客户端特征
        UserAgent agent=UserAgent.parseUserAgentString(userAgent);
        if (agent.getOperatingSystem().isMobileDevice()) {
            strB.append(Common.MOBILE+"-");
        }else {
            strB.append(Common.PC+"-");
        }
        //userCode MD5加密
        String userCode=user.getUsercode();
        strB.append(DigestUtils.md5Hex(userCode)+"-");
        //userId
        strB.append(user.getUserid()+"-");
        //创建时间
        Date now = new Date();
        DateFormat format=new SimpleDateFormat("yyyyMMddHHmmsss");
        String dataStr="";
        dataStr = format.format(now);
        strB.append(dataStr+"-");
        //agent MD5 截取前6位
        String agentMD5=DigestUtils.md5Hex(userAgent);
        agentMD5=agentMD5.substring(0,6);
        strB.append(agentMD5);
        return strB.toString();
    }

    @Override
    public Integer saveToken(String token, User user) {
        //user->json
        String json = JSON.toJSONString(user);
        redisUtil.set(token,json,Common.TOKEN_TIMEOUT);
        return 1;
    }

    //token验证
    @Override
    public Boolean checkToken(String token, String userAgent) {
        //1. 通过入参token查询Redis中是否有符合的记录
        Object userJson = redisUtil.get(token);
        if (null == userJson) {

            return false;
        }

        //2. 验证userAgent的信息是否与登录时生成的一致
        String oldAgent=token.split("-")[4];
        String newAgent=DigestUtils.md5Hex(userAgent).substring(0,6);
        if(oldAgent.equals(newAgent)){
            return true;
        }
        return false;
    }

    @Override
    public TokenDto logout(String token, String userAgent) {
        TokenDto tokenDto=new TokenDto();
        //验证
        Boolean result = checkToken(token, userAgent);
        if (!result) {
            tokenDto.setErrorcode(Common.CODE_03);
            return tokenDto;
        }
        redisUtil.delete(token);
        tokenDto.setErrorcode(Common.CODE_SUCCESS);
        return tokenDto;
    }


}
