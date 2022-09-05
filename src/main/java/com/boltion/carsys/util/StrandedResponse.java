package com.boltion.carsys.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrandedResponse {
    private boolean state;
    private String message;
    private Object data;

    public StrandedResponse(boolean state, String message) {
        this.state = state;
        this.message = message;
    }
}
