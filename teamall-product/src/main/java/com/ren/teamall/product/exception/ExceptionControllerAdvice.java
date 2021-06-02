package com.ren.teamall.product.exception;

import com.ren.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author renjian
 * @creaate 2021-06-02 16:34
 * function
 * description
 * - 异常统一处理
 */

@Slf4j
/*@ResponseBody
@ControllerAdvice(basePackages = "com.ren.teamall.product.controller")*/

@RestControllerAdvice(basePackages = "com.ren.teamall.product.controller")
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e) {

        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        //获取校验结果
        bindingResult.getFieldErrors().forEach((item) -> {
            String message = item.getDefaultMessage(); //配置文件中的，，想要自己的可以在entity上添加
            String filed = item.getField();
            map.put(filed, message);
        });
        return R.error(400, "提交的数据不合法！").put("data", map);

    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable e) {
        return R.error();
    }
}
