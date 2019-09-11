package cn.tcmp.six.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WyjPageUtils<T> implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
    private Integer totalPageCount;
    private List<T> list;
    //所有导航页号
    private int[] navigatepageNums;

}
