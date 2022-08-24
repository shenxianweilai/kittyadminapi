package fun.miaomi.Kittyadmin.exception;

import fun.miaomi.Kittyadmin.result.ResultCode;
import fun.miaomi.Kittyadmin.result.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(APIException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO<Object> APIExceptionHandler(APIException e) {
        log.error("api异常");
        return new ResultVO<>(ResultCode.FAILED, e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO<Object> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("方法参数错误异常");
        List<String> list = new ArrayList<>();
        if (!e.getBindingResult().getAllErrors().isEmpty()) {
            for (ObjectError error: e.getBindingResult().getAllErrors()) {
                list.add(error.getDefaultMessage().toString());
            }
        }
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, list);
    }
}
