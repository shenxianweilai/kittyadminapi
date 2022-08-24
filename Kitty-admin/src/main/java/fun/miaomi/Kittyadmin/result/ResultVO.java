package fun.miaomi.Kittyadmin.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultVO<T> {
    private int code;
    private String msg;
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
