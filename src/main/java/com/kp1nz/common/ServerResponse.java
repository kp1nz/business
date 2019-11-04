package com.kp1nz.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.Gson;
import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 服务端返回到前端的高复用的相应对象
 *
 * @author kp1nz
 * @create 2019-01-04 18:05
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> {
    private Integer status;//返回到前端的状态码
    private String msg;//当code!=0时 封装了错误信息
    private T data;//当code==0时 返回到前端的数据

    private ServerResponse() {

    }

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 调用成功时的回调
     */
    public static ServerResponse serverResponseBySuccess() {
        return new ServerResponse(ResponseCode.SUCESS);
    }

    public static <T> ServerResponse serverResponseBySuccess(T data) {
        return new ServerResponse(ResponseCode.SUCESS, data);
    }

    public static <T> ServerResponse serverResponseBySuccess(T data, String msg) {
        return new ServerResponse(ResponseCode.SUCESS, data, msg);
    }

    /**
     * 调用失败时回调
     */
    public static ServerResponse serverResponseByError() {
        return new ServerResponse(ResponseCode.ERROR);
    }

    public static ServerResponse serverResponseByError(String msg) {
        return new ServerResponse(ResponseCode.ERROR, msg);
    }

    public static ServerResponse serverResponseByError(int status) {
        return new ServerResponse(status);
    }

    public static ServerResponse serverResponseByError(int status, String msg) {
        return new ServerResponse(status, msg);
    }

    /**
     * 判断接口是否正确返回
     * status==0
     */
    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCESS;
    }

    public void ServerResponse2json(HttpServletResponse response,ServerResponse serverResponse) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(serverResponse);
        //重构HttpServerletResponse
        response.reset();
        //设置字符编码
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter printWriter = response.getWriter();
        printWriter.write(json);
        printWriter.flush();
        printWriter.close();













    }
}
