package com.example.rasello.response;

public class Response {
    private Integer code;
    private Boolean success;
    private String message;

    public Response() {}

    public Response(Integer code, Boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }
}
