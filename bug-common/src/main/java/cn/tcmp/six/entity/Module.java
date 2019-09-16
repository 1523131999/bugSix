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
    private Project projectid;
    private String modeuleName;
    private String describe;
    private User Kassign;
    private User cassign;

    private Integer isagreen;

}
