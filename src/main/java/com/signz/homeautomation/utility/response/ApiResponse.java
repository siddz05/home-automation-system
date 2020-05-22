package com.signz.homeautomation.utility.response;


import lombok.Data;

import javax.servlet.http.HttpServletResponse;

@Data
public class ApiResponse<T> implements BaseResponse<T> {

    final Integer SUCCESS_STATUS = 200;

    int status;
    String message;
    T data;

    public ApiResponse(HttpServletResponse response, T data) {
        this.status = SUCCESS_STATUS;
        this.data = data;
        response.setStatus(this.status);
    }

    public ApiResponse(HttpServletResponse response, T data, String message) {
        this.status = SUCCESS_STATUS;
        this.data = data;
        this.message = message;
        response.setStatus(this.status);
    }

    public ApiResponse(HttpServletResponse response, int status, T data) {
        this.status = status;
        this.data = data;
        response.setStatus(status);
    }

    public ApiResponse(HttpServletResponse response, int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
        response.setStatus(status);
    }
}
