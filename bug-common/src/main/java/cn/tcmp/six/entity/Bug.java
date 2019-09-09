package cn.tcmp.six.entity;

import java.io.Serializable;
import java.util.Date;

public class Bug implements Serializable {

    private Integer id;
    private Integer taskid;
    private Integer userid;
    private Integer priority;
    private Date date;
    private String describe;
    private Integer isreproduce;


}
