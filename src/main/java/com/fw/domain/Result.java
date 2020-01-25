package com.fw.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

@Component("result")
public class Result implements Serializable {
    private Map<String,Object> data;
    private Integer code;
    private String message;

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
