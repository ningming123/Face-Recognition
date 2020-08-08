package com.example.face.utils.json;




/**
 * @description:返回结果简单操作类 ok：成功操作；error：业务失败操作；serverError：系统错误
 * @version: 1.0
 */
public class JsonResultUtil {
    /**
     * 使用GlobalReturnCode.OK返回
     *
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> ok() {
        return new JsonResult<E>(GlobalReturnCode.OK);
    }

    /**
     * 使用GlobalReturnCode.OK+自定义返回对象
     *
     * @param e   自定义返回对象
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> ok(E e) {
        return new JsonResult<E>(GlobalReturnCode.OK, e);
    }

    /**
     * 使用自定义消息+自定义对象
     *
     * @param msg 自定义消息
     * @param e   自定义对象
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> ok(String msg, E e) {
        return new JsonResult<E>(GlobalReturnCode.OK, msg, e);
    }

    /**
     * 使用自定义returnCode+自定义消息+自定义对象返回
     *
     * @param returnCode 自定义returnCode
     * @param msg        自定义消息
     * @param e          自定义对象返回
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> ok(String returnCode, String msg, E e) {
        return new JsonResult<E>(returnCode, msg, e);
    }

    /**
     * 使用GlobalReturnCode.SERVER_ERROR返回系统错误
     *
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> serverError() {
        return new JsonResult<E>(GlobalReturnCode.SERVER_ERROR);
    }

    /**
     * 使用GlobalReturnCode.SERVER_ERROR+自定义消息返回系统错误
     *
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> serverError(String msg) {
        return new JsonResult<E>(GlobalReturnCode.SERVER_ERROR, msg, null);
    }

    /**
     * 使用GlobalReturnCode.SERVER_ERROR返回系统错误代码，使用自定义消息，使用自定义返回对象
     *
     * @param <E>
     * @param msg 自定义消息
     * @return
     */
    public static <E> JsonResult<E> serverError(String msg, E e) {
        return new JsonResult<E>(GlobalReturnCode.SERVER_ERROR);
    }

    /**
     * 使用自定义返回码+自定义返回对象
     *
     * @param <E>
     * @param globalReturnCode 自定义系统返回码
     * @param e                自定义返回对象
     * @return
     */
    public static <E> JsonResult<E> serverError(GlobalReturnCode globalReturnCode, E e) {
        return new JsonResult<E>(globalReturnCode, e);
    }

    /**
     * 使用自定义返回码
     *
     * @param <E>
     * @param globalReturnCode 自定义系统返回码
     * @return
     */
    public static <E> JsonResult<E> serverError(GlobalReturnCode globalReturnCode) {
        return new JsonResult<E>(globalReturnCode);
    }

    /**
     * 使用GlobalReturnCode.BUSINESS_ERROR返回
     *
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> error() {
        return new JsonResult<E>(GlobalReturnCode.BUSINESS_ERROR);
    }

    /**
     * 使用自定义对象填充JsonResult-data对象
     *
     * @param e   需要附带的数据对象
     * @param <E> 不能是String类型，如果想传递String类型数据作为data，应该使用error(String msg,E e);
     * @return
     */
    public static <E> JsonResult<E> error(E e) {
        return new JsonResult<E>(GlobalReturnCode.BUSINESS_ERROR, e);
    }

    /**
     * 使用自定义消息填充JsonResult-data对象
     *
     * @param msg 自定义消息
     * @return
     */
    public static JsonResult error(String msg) {
        return new JsonResult(GlobalReturnCode.BUSINESS_ERROR, msg, null);
    }

    /**
     * 将异常信息作为msg返回
     *
     * @param exception 异常对象
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> error(Exception exception) {
        return new JsonResult<E>(GlobalReturnCode.BUSINESS_ERROR, exception.getMessage(), null);
    }

    /**
     * 使用其他GlobalReturnCode来返回JsonResult
     *
     * @param globalReturnCode GlobalReturnCode枚举
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> error(GlobalReturnCode globalReturnCode) {
        return new JsonResult<E>(globalReturnCode);
    }

    /**
     * 使用其他GlobalReturnCode+附加的实体对象来返回JsonResult
     *
     * @param globalReturnCode GlobalReturnCode枚举
     * @param e                附加返回对象
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> error(GlobalReturnCode globalReturnCode, E e) {
        return new JsonResult<E>(globalReturnCode, e);
    }

    /**
     * 使用自定义的返回码+异常信息返回JsonResult
     *
     * @param returnCode 自定义返回码
     * @param exception  异常对象
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> error(String returnCode, Exception exception) {
        return new JsonResult<E>(returnCode, exception.getMessage(), null);
    }

    /**
     * 使用默认的GlobalReturnCode.BUSINESS_ERROR中的ReturnCode+自定义的消息+附加返回对象
     *
     * @param msg 自定义消息
     * @param e   附加返回对象
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> error(String msg, E e) {
        return new JsonResult<E>(GlobalReturnCode.BUSINESS_ERROR, msg, e);
    }

    /**
     * 使用自定义返回码+自定义消息+附加对象进行返回
     *
     * @param returnCode 自定义返回码
     * @param msg        自定义消息
     * @param e          附加返回对象
     * @param <E>
     * @return
     */
    public static <E> JsonResult<E> error(String returnCode, String msg, E e) {
        return new JsonResult<E>(returnCode, msg, e);
    }

    /**
     * 使用自定义返回码+自定义消息+异常对象进行返回
     *
     * @param returnCode 自定义返回码
     * @param msg        自定义消息
     * @param exception  异常对象
     * @return
     */
    public static JsonResult error(String returnCode, String msg, Exception exception) {
        return new JsonResult(returnCode, msg, exception.getMessage());
    }

}

