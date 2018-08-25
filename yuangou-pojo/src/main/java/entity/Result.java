package entity;

import java.io.Serializable;

/**
 * @Author: 烈日下的酋长
 * @Date: 2018/8/25 15:13
 * @Version 1.0
 */
public class Result implements Serializable {

    private Boolean success;
    private String message;

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
