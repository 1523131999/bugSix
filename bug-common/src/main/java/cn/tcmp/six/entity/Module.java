package cn.tcmp.six.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Module implements Serializable {

    private Integer id;
    private Integer projectid;
    private String modeuleName;
    private String describe;
    private Integer Kassign;
    private Integer cassign;

}
