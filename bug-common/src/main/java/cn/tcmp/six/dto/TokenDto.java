package cn.tcmp.six.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/8/26/026.
 */
public class TokenDto implements Serializable{
    private DataDto data;
    private String errorcode;

    public DataDto getData() {
        return data;
    }

    public void setData(DataDto data) {
        this.data = data;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }
}
