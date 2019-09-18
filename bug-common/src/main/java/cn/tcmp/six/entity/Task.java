package cn.tcmp.six.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {

    private Integer id;
    private Module moduleid;
    private Date Estimateddate;
    private Date enddate;
    private Integer priority;
    private User assign;
    private User createUser;
    private Integer isEnd;
    private String taskName;

}
