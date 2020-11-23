package com.commons.entity;


import com.commons.status.ExceptionEnum;
import lombok.Data;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.io.Serializable;


/**
 * @author rhys.ni
 */
@Data
public class Result<T>  implements Serializable {

    private Integer code;

    private boolean success;

    private String message;

    private Object data;

    public static <T> Mono<Result<T>> ok(Mono<T> monoBody) {
        return resultBodyCreate(ExceptionEnum.SUCCESS.value(), true, null, monoBody);
    }


    public static <T> Mono<Result<T>> fail(Mono<T> monoBody) {
        return resultBodyCreate(ExceptionEnum.SERVER_ERROR.value(), true, null, monoBody);
    }


    public static <T> Mono<Result<T>> response(int code,Boolean success,String msg,Mono<T> monoBody) {
        return resultBodyCreate(code, success, msg, monoBody);
    }


    private static <T> Mono<Result<T>> resultBodyCreate(int code, Boolean success, String msg, Mono<T> monoData) {
        return monoData.map(data -> {
            final Result<T> result = new Result<>();
            result.setCode(code);
            result.setSuccess(success);
            result.setData(data);
            result.setMessage(msg);
            return result;
        });
    }
}