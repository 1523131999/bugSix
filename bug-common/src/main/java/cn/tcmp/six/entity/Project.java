package cn.tcmp.six.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {

    private Integer id;
    private String projectName;
    private String projectCode;
    private String stardate;
    private String enddate;
    private String teamName;
    private String projecttype;
    private String describe;
    private Integer isstate;
}
