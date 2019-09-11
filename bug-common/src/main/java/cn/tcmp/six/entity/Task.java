package cn.tcmp.six.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Task implements Serializable {

    private Integer id;
    private Integer moduleid;
    private Date Estimateddate;
    private Date enddate;
    private Integer priority;
    private Integer assign;
    private Integer createUser;

}
