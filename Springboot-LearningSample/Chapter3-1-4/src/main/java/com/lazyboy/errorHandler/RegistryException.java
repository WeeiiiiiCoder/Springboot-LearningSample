package com.lazyboy.errorHandler;

/**
 * 模拟注册异常
 */
public class RegistryException extends RuntimeException {
    public RegistryException(String message) {
        super(message);
    }
}
