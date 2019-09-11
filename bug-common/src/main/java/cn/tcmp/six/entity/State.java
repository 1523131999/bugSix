package cn.tcmp.six.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class State implements Serializable {

    private Integer id;
    private String typecode;
    private Integer vlueid;
    private String valueName;
}
