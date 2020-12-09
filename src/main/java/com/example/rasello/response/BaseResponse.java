package com.example.rasello.response;

public class BaseResponse <T> extends  Response{
    private T data;

    public BaseResponse(Integer code, Boolean success, String message, T data) {
        super(code, success, message);
        this.data = data;
    }

    public BaseResponse(Integer code, Boolean success, String message) {
        super(code, success, message);
        this.data = data;

    }
}
