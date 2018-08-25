package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: 烈日下的酋长
 * @Date: 2018/8/25 13:53
 * @Version 1.0
 */
public class PageResult implements Serializable {
    private long total;//总记录数
    private List rows;//当前的页数

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
