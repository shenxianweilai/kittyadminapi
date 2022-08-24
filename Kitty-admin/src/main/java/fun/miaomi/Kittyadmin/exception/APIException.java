package fun.miaomi.Kittyadmin.exception;

import fun.miaomi.Kittyadmin.result.ResultCode;
import lombok.Getter;

@Getter
public class APIException extends RuntimeException{
    private int code;
    private String msg;

    public APIException() {
        this(ResultCode.FAILED);
    }

    public APIException(ResultCode failed) {
        this.code = failed.getCode();
        this.msg = failed.getMsg();
    }
}
