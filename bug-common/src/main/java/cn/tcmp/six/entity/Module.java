package cn.tcmp.six.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module implements Serializable {

    private Integer id;
    private Integer projectid;
    private String modeuleName;
    private String describe;
    private Integer Kassign;
    private Integer cassign;

}
