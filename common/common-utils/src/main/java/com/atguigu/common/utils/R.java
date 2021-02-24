package com.atguigu.common.utils;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: R
 * @Description: 统一响应格式数据
 * @Author: 张欢
 * @Date 2021/2/24 22:23
 * @Version: 1.0
 */
@Data
public class R {

    private Boolean success; // 是否成功

    private Integer code; // 响应码

    private String message; // 响应消息

    private Map<String, Object> data = new HashMap<>(); // 返回数据

    /**
     * 私有化构造方法，不允许new对象
     * 提供静态方法
     */
    private R() {
    }

    public static R success() {
        R r = new R();
        r.setCode(ResultCode.success);
        r.setSuccess(Boolean.TRUE);
        r.setMessage("成功");
        return r;
    }

    public static R fail() {
        R r = new R();
        r.setCode(ResultCode.fail);
        r.setSuccess(Boolean.FALSE);
        r.setMessage("失败");
        return r;
    }

    public R success(Boolean successFlag) {
        this.setSuccess(successFlag);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

}
