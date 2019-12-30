package com.lazyboy.dto;

/**
 * Response通用对象
 *
 * @param <T>
 */
public class CommRes<T> {

    public static final int STATUS_OK = 0;
    public static final int STATUS_ERROR = 100;

    private int code;

    private String messsage;
    private String url;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}