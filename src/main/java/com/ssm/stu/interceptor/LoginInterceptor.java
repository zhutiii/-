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

        /* 获取session对象 */
        HttpSession session = request.getSession();
        /* 获取请求的uri  就是域名后面的那一节 */
        String uri = request.getRequestURI();
        // session.getAttribute("userInfo")!=null session中有用户信息说明登录过了
        //uri.indexOf("/adminlog")!=-1   登录接口不拦截
        //uri.indexOf(".")!=-1 所有带.的接口不拦截  如"*.css","*.js"等
        //uri.indexOf("/logout")!=-1 退出接口不拦截
        if(session.getAttribute("userInfo")!=null || uri.indexOf("/studentLogin") != -1 || uri.indexOf("/maintainerLogin") != -1  || uri.indexOf("/adminlog")!=-1 || uri.indexOf(".")!=-1 || uri.indexOf("/logout")!=-1) {
            return true;
        }
        //返回错误  通过写的方式
        response.getWriter().write("{'code':500,'msg':'No Login!!'}");
        return false;
    }

}
