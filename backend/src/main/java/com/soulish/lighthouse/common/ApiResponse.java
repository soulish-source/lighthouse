package com.soulish.lighthouse.common;

public class ApiResponse<T> {
    private boolean success;
    private T data;

    public ApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(true, data);
    }

    public boolean isSuccess() { return success; }
    public T getData() { return data; }
}
