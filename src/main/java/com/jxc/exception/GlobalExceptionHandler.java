package com.jxc.exception;

import com.jxc.entity.Result;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.log4j.Log4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 */
@ResponseBody
@Log4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("参数解析失败", e);
        return Result.fail("Couldn't read request param.");
    }

    /**
     * 404 - Can't find resource
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.fail("Couldn't find resource(USU is request 404 error)");
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("不支持当前请求方法", e);
        return Result.fail("Request method is not supported.");
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result handleHttpMediaTypeNotSupportedException(Exception e) {
        log.error("不支持当前媒体类型", e);
        return Result.fail("The current content type is not supported.");
    }

    /**
     * 方法参数校验(接收参数加上 @ModelAttribute, @RequestBody, and @RequestPart注解才会有这种异常)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("方法参数校验失败", e);
        return Result.fail(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(BindException.class)
    public Result bindException(BindException ex, HttpServletRequest request) {
        log.error("数据绑定异常", ex);
        try {
            // 拿到@NotNull,@NotBlank和 @NotEmpty等注解上的message值
            String msg = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
            if (StringUtils.isNotEmpty(msg)) {
                // 自定义状态返回
                return Result.fail(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 参数类型不匹配检验
        StringBuilder msg = new StringBuilder();
        List<FieldError> fieldErrors = ex.getFieldErrors();
        fieldErrors.forEach((oe) ->
                msg.append("参数:[").append(oe.getObjectName())
                        .append(".").append(oe.getField())
                        .append("]的传入值:[").append(oe.getRejectedValue()).append("]与预期的字段类型不匹配.")
        );
        return Result.fail(msg.toString());
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public Result handleValidationException(ValidationException e) {
        log.error("校验异常", e);
        return Result.fail(e.getCause().getMessage());
    }

    /**
     * ConstraintViolationException：注解类型的异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleConstraintViolationException(ConstraintViolationException e) {
        log.error("注解校验异常", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
        return Result.fail(message);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("主键冲突", e);
        return Result.fail("数据重复，请检查后提交");
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        if (e instanceof ServletRequestBindingException){
            log.error("缺少请求头设置", e);
            if (e instanceof MissingRequestHeaderException){
                return Result.fail("The request params had exist missing header.");
            }
            return Result.fail("Bind request params error.");
        }

        if (e instanceof BizException){
            log.error("业务异常", e);
            return Result.fail("The system has a business error.");
        }

        log.error("服务运行异常", e);
        e.printStackTrace();
        return Result.fail("Server error.");
    }
}
