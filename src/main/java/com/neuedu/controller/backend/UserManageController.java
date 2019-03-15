package com.neuedu.controller.backend;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import com.neuedu.utils.IpUtils;
import com.neuedu.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 后台用户管理控制器
 * @author kp1nz
 * @create 2019-01-05 18:24
 */
@RestController
@RequestMapping(value = "/manage/user")
public class UserManageController {

    @Autowired
    IUserService userService;

    /**
     * 管理员登录
     */
    @RequestMapping(value = "/login.do")
    public ServerResponse login(HttpServletRequest request, HttpServletResponse response, HttpSession session, String username, String password){
        ServerResponse serverResponse=userService.login(username,password);
        if(serverResponse.isSuccess()){//登录成功
            UserInfo userInfo=(UserInfo) serverResponse.getData();
            if(userInfo.getRole()==Const.RoleEnum.ROLE_CUSTOMER.getCode()){
                return ServerResponse.serverResponseByError("无权限登录");
            }
            session.setAttribute(Const.CURRENTUSER,userInfo);
            //生成autoLoginToken
            String ip = IpUtils.getRemoteAddress(request);
            try {
                String mac = IpUtils.getMACAddress(ip);
                String token = MD5Utils.getMD5Code(mac);
                //将token保存到数据库
                userService.updateTokenByUserid(userInfo.getId(),token);
                //
                Cookie autoLoginTokenCookie = new Cookie(Const.AUTOLOGINTOKEN,token);
                autoLoginTokenCookie.setMaxAge(60*60*7*24);//7天
                autoLoginTokenCookie.setPath("/");
                response.addCookie(autoLoginTokenCookie);

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }


        return  serverResponse;
    }
}
