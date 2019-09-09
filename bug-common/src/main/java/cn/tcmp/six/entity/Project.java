package cn.tcmp.six.entity;

import java.io.Serializable;
import java.util.Date;

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
