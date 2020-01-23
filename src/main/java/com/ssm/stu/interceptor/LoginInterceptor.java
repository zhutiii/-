package com.ssm.stu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName:LoginInterceptor
 * Function:登录拦截器。未登录则不能访问页面
 * Reason:
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        //执行完毕，返回前拦截
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        //处理过程中执行拦截
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        //在拦截点执行前拦截，如果返回true则不执行拦截点后的操作（拦截成功）
        //返回false则不执行拦截
        HttpSession session = request.getSession();
        String uri = request.getRequestURI(); // 获取登录的uri，这个是不进行拦截的
        if(session.getAttribute("userInfo")!=null || uri.indexOf("/adminlog")!=-1 || uri.indexOf(".")!=-1 || uri.indexOf("/logout")!=-1) {
            return true;
        }
        //登录失败，跳转到登录页
//        response.sendRedirect(request.getContextPath());
        response.getWriter().write("{'code':500,'msg':'No Login!!'}");
        return false;
    }

}
