package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        SysException sysException = null;
        if (e instanceof SysException){
            sysException=(SysException) e;
        }else {
            sysException=new SysException("系统错误");
        }
        modelAndView.addObject("errorMsg", sysException.getMsg());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
