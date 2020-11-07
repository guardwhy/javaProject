package cn.guardwhy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.创建session对象
        HttpSession session = request.getSession();

        // 2.提交登录操作会放行
        if(request.getRequestURI().contains("login")){
            return true;
        }
        // 3.第一次登入,没有session，所以放行
        if(session.getAttribute("userLoginInfo") != null){
            return true;
        }
        // 4.登录页面会放行
        if(request.getRequestURI().contains("jumpLogin")){
            return true;
        }

        // 5.判断什么情况下没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}
