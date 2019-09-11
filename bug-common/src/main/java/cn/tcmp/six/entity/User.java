package cn.tcmp.six.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {

    private Integer userid;
    private String usercode;
    private String password;
    private String username;
    private Integer userroels;
}
