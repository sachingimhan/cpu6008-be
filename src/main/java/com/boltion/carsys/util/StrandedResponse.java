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
}
