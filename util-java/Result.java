package com.chngenesis.nebula.util;

import com.chngenesis.nebula.base.impl.BaseModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.Map;

/**
 * 业务数据消息返回层
 */
public final class Result implements Serializable {
    private static final long serialVersionUID = -512288602524117117L;

    /**
     * @param result  Map集合
     * @param message 错误消息
     * @return
     */
    public static Map<String, Object> resultError(Map<String, Object> result, String message) {
        result.put("error", true);
        result.put("message", StringUtils.isNotBlank(message) ? message : SystemConstant.SystemConfigMessage.OPERATION_FAILURE);
        return result;
    }

    public static Map<String, Object> resultSuccess(Map<String, Object> result) {
        result.put("error", false);
        result.put("message", SystemConstant.SystemConfigMessage.OPERATION_SUCCESSFULLY);
        return result;
    }


    public static Map<String, Object> resultError(Map<String, Object> result) {
        result.put("error", true);
        result.put("message", SystemConstant.SystemConfigMessage.OPERATION_FAILURE);
        return result;
    }

    /**
     * @param result  Map集合
     * @param message 正确消息
     * @return
     */
    public static Map<String, Object> resultSuccess(Map<String, Object> result, String message) {
        result.put("error", false);
        result.put("message", StringUtils.isNotBlank(message) ? message : SystemConstant.SystemConfigMessage.OPERATION_FAILURE);
        return result;
    }

    /**
     * @param result  BaseModel
     * @param message 错误消息
     * @return
     */
    public static BaseModel<T>  resultError(BaseModel<T> result, String message) {
        result.setError(true);
        result.setMessage(StringUtils.isNotBlank(message) ? message : SystemConstant.SystemConfigMessage.OPERATION_FAILURE);
        return result;
    }

    public static BaseModel<T> resultError(BaseModel<T> result) {
        result.setError(true);
        result.setMessage(SystemConstant.SystemConfigMessage.OPERATION_FAILURE);
        return result;
    }

    public static BaseModel<T>  resultSuccess(BaseModel<T> result) {
        result.setError(false);
        result.setMessage(SystemConstant.SystemConfigMessage.OPERATION_FAILURE);
        return result;
    }

    /**
     * @param result  BaseModel
     * @param message 正确消息
     * @return
     */
    public static BaseModel<T>  resultSuccess(BaseModel<T> result, String message) {
        result.setError(false);
        result.setMessage(StringUtils.isNotBlank(message) ? message : SystemConstant.SystemConfigMessage.OPERATION_SUCCESSFULLY);
        return result;
    }
}
