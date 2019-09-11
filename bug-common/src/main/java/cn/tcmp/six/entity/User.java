package cn.tcmp.six.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer userid;
    private String usercode;
    private String password;
    private String username;
    private Integer userroels;
}
