package com.lazyboy.errorHandler;

import com.lazyboy.dto.CommRes;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
        //需要模板引擎支持
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorDetail", e.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    /*@ExceptionHandler注解指定该方法用于处理指定的异常*/
    @ExceptionHandler(value = RegistryException.class)
    @ResponseBody
    public CommRes registryError(HttpServletRequest httpRequest, Exception e) {
        CommRes<String> response = new CommRes<>();
        response.setCode(CommRes.STATUS_ERROR);
        response.setMesssage(e.getMessage());
        response.setUrl(httpRequest.getRequestURL().toString());
        response.setData("LAZYBOY");
        return response;
    }
}
