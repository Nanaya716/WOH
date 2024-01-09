package com.jxc.exception;

/**
 * 自定义业务异常，可以在具体业务处理过程中抛出交给调用者处理
 */
public class BizException extends RuntimeException {
    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }
}
