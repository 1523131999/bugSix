package cn.tcmp.six.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.io.Serializable;
import java.util.Date;
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Bug implements Serializable {

    private Integer id;
    private Integer taskid;
    private Integer userid;
    private Integer priority;
    private String date;
    private String describe;
    private Integer isreproduce;
    private Integer statu;


}
