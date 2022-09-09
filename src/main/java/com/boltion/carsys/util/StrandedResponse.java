package com.boltion.carsys.util;

import lombok.Data;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@Data
public class StrandedResponse {
    private boolean state;
    private String message;
    private Object data;

    public StrandedResponse() {
    }

    public StrandedResponse(boolean state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StrandedResponse{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
