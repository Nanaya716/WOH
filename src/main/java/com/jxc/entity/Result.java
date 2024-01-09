package com.jxc.entity;

public class Result {
    private Long count;
    private Integer total;
    private String code;
    private String msg;
    private Object data;

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code, String msg, Long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Result(Long count, Integer total, String code, String msg, Object data) {
        this.count = count;
        this.total = total;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result ok(){
        return new Result("0", "操作成功！");
    }
    public static Result ok(String msg){
        return new Result("0", msg);
    }
    public static Result ok(String msg, Object obj){
        return new Result("0", msg, obj);
    }
    public static Result ok(String msg, Long count, Object obj){
        return new Result("0", "", count, obj);
    }
    public static Result fail(){
        return new Result("-1", "操作失败！");
    }
    public static Result fail(String msg){
        return new Result("-1", msg);
    }
}
