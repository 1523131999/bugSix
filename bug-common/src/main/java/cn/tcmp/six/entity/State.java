package cn.tcmp.six.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class State implements Serializable {

    private Integer id;
    private String typecode;
    private Integer vlueid;
    private String valueName;
}
