package com.braisedPanda.model;

import lombok.Data;

/**
 * @program: course-selection-system
 * @description: 返回模型
 * @author: chenzhen
 * @create: 2020-12-09 17:15
 **/
@Data
public class ResponseStatus<T> {
    // 返回编码
    private Integer code;
    // 返回信息
    private String message;
    // 返回数据
    private T data;


    public ResponseStatus(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public ResponseStatus(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseStatus(ResponseEnum enums){
        this.code = enums.getCode();
        this.message = enums.getMessage();
    }

    public ResponseStatus(ResponseEnum enums, String message){
        this.code = enums.getCode();
        this.message = message;
    }

    public ResponseStatus(ResponseEnum enums, T data){
        this.code = enums.getCode();
        this.message = enums.getMessage();
        this.data = data;
    }

    /**
    * 返回成功
    * @param
    * @return com.braisedPanda.model.ResponseStatus<T>
    * @author chenzhen
    * @date 2020/12/9 0009
    */
    public static <T> ResponseStatus<T> success(){
        return new ResponseStatus<T>(ResponseEnum.SUCCESS);
    }

    /**
     * 返回成功，自定义成功信息
     * @param
     * @return com.braisedPanda.model.ResponseStatus<T>
     * @author chenzhen
     * @date 2020/12/9 0009
     */
    public static <T> ResponseStatus<T> success(String message){
        return new ResponseStatus<T>(ResponseEnum.SUCCESS, message);
    }

    /**
     * 返回成功，带返回数据
     * @param
     * @return com.braisedPanda.model.ResponseStatus<T>
     * @author chenzhen
     * @date 2020/12/9 0009
     */
    public static <T> ResponseStatus<T> success(ResponseEnum enums, T data){

        return new ResponseStatus<T>(ResponseEnum.SUCCESS, data);
    }
    
    /**
    * 返回失败
    * @param 
    * @return com.braisedPanda.model.ResponseStatus<T>
    * @author chenzhen      
    * @date 2020/12/9 0009
    */ 
    public static <T> ResponseStatus<T> fail(){
        return new ResponseStatus<T>(ResponseEnum.FAIL);
    }

    /**
     * 返回失败,带自定义返回信息
     * @param
     * @return com.braisedPanda.model.ResponseStatus<T>
     * @author chenzhen
     * @date 2020/12/9 0009
     */
    public static <T> ResponseStatus<T> fail(String message){
        return new ResponseStatus<T>(ResponseEnum.FAIL, message);
    }



}
