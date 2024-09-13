package com.example.demo.Utils;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;


    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 快速返回操作成功响应结果(带响应数据)
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "Success", data);
    }

    // 快速返回操作成功响应结果
    public static Result<Void> success() {
        return new Result<>(0, "Success", null);
    }

    // 返回错误响应结果
    public static Result<Void> error(String message) {
        return new Result<>(1, message, null);
    }
}