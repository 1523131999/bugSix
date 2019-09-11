package cn.tcmp.six.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/8/26/026.
 */
public class DataDto implements Serializable {
    private String token;
    private String genTime;
    private String expTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGenTime() {
        return genTime;
    }

    public void setGenTime(String genTime) {
        this.genTime = genTime;
    }

    public String getExpTime() {
        return expTime;
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }
}
