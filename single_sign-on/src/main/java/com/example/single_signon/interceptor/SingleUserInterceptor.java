package com.example.single_signon.interceptor;

import com.example.single_signon.bean.User;
import com.example.single_signon.util.MemoryData;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：nightwalker
 * @date ：Created in 19-11-24 下午1:28
 * @description：单点登录拦截器
 */

@Component
public class SingleUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        // 如果拦截到登录界面放行
        if (url.indexOf("login.html") >= 0 || url.indexOf("checkUser") >= 0) {
            return true;
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            String key = user.getuName();
            String sessionId = MemoryData.getSessionIdMap().get(key);
            if (sessionId.equals(request.getSession().getId())) {
                return true;
            } else {
                if (request.getHeader("x-requested-with") != null
                        && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                    response.setHeader("sessionstatus", "timeout");
                    return false;

                } else {
                    String indexurl = request.getContextPath() + "/login.html";
                    response.sendRedirect(indexurl);
                    return false;
                }
            }
        }
        //如果session中没有admin，跳转到登陆页
        request.getRequestDispatcher(request.getContextPath() + "/login.html").forward(request, response);

        return false;
    }
}
