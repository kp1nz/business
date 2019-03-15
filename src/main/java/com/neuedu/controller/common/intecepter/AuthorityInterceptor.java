package com.neuedu.controller.common.intecepter;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author kp1nz
 * @create 2019-01-17 14:32
 */
@Component
public class AuthorityInterceptor implements HandlerInterceptor {

    @Autowired
    IUserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("==================intopreInterceptor...====================");
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENTUSER);
        //设置字符编码
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        if(userInfo ==null){
            Cookie[] cookies = request.getCookies();
            if (cookies!=null && cookies.length>0){
                for (Cookie c : cookies){
                    String cookiename = c.getName();
                    if(cookiename.equals(Const.AUTOLOGINTOKEN)){
                        String autoLoginToken = c.getValue();
                        //根据token查询用户
                        userInfo = userService.findUserInfoByToken(autoLoginToken);
                        if(userInfo!=null){
                            session.setAttribute(Const.CURRENTUSER,userInfo);
                        }
                        break;
                    }
                }
            }
        }

        if(userInfo ==null||userInfo.getRole()!=Const.RoleEnum.ROLE_ADMIN.getCode()){
            //判断用户是否登录
            if (userInfo == null) {
                ServerResponse serverResponse = ServerResponse.serverResponseByError("用户未登录");
                serverResponse.ServerResponse2json(response,serverResponse);
                return  false;
            }
            //判断用户权限
            if (userInfo.getRole() != Const.RoleEnum.ROLE_ADMIN.getCode()) {
                ServerResponse serverResponse = ServerResponse.serverResponseByError("无权限操作");
                serverResponse.ServerResponse2json(response,serverResponse);
                return  false;
            }
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }


}
