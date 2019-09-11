package cn.tcmp.six.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Project implements Serializable {

    private Integer id;
    private String projectName;
    private String projectCode;
    private Date stardate;
    private Date enddate;
    private String teamName;
    private String projecttype;
    private String describe;
}
