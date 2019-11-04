package com.kp1nz.controller.portal;

import com.kp1nz.common.Const;
import com.kp1nz.common.ServerResponse;
import com.kp1nz.pojo.Shipping;
import com.kp1nz.pojo.UserInfo;
import com.kp1nz.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 地址模块
 * @author kp1nz
 * @create 2019-01-10 19:58
 */
@RestController
@RequestMapping(value = "/shipping")
public class AddressController {
    @Autowired
    IAddressService addressService;

    /**
     * 添加地址
     */
    @RequestMapping(value = "/add.do")
    public ServerResponse add(HttpSession session, Shipping shipping) {
        UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENTUSER);
        if (userInfo == null) {
            return ServerResponse.serverResponseByError("请先登录");
        }
        return addressService.add(userInfo.getId(), shipping);
    }

    /**
     * 删除地址
     */
    @RequestMapping(value = "/del.do")
    public ServerResponse del(HttpSession session, Integer shippingId) {
        UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENTUSER);
        if (userInfo == null) {
            return ServerResponse.serverResponseByError("请先登录");
        }
        return addressService.del(userInfo.getId(), shippingId);
    }

    /**
     * 更新地址
     */
    @RequestMapping(value = "/update.do")
    public ServerResponse update(HttpSession session, Shipping shipping) {
        UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENTUSER);
        if (userInfo == null) {
            return ServerResponse.serverResponseByError("请先登录");
        }
        shipping.setUserId(userInfo.getId());
        return addressService.update(shipping);
    }

    /**
     * 查看选中地址
     */
    @RequestMapping(value = "/select.do")
    public ServerResponse select(HttpSession session, Integer shippingId) {
        UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENTUSER);
        if (userInfo == null) {
            return ServerResponse.serverResponseByError("请先登录");
        }
        return addressService.select(shippingId);
    }

    /**
     * 分页查询地址列表
     */
    @RequestMapping(value = "/list.do")
    public ServerResponse list(HttpSession session,
                               @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENTUSER);
        if (userInfo == null) {
            return ServerResponse.serverResponseByError("请先登录");
        }
        return addressService.list(pageNum, pageSize);
    }
}
