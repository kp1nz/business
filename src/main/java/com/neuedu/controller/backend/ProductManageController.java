package com.neuedu.controller.backend;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Product;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * @author kp1nz
 * @create 2019-01-08 13:53
 */
@RestController
@RequestMapping(value = "/manage/product")
public class ProductManageController {

    @Autowired
    IProductService productService;

    /**
     * 新增or更新商品
     */
    @RequestMapping("/save.do")
    public ServerResponse saveOrUpdate(HttpSession session, Product product) {
        //判断用户是否登录
        //判断用户权限
        return productService.saveOrUpdate(product);
    }

    /**
     * 商品上下架
     */
    @RequestMapping("/set_sale_status.do")
    public ServerResponse set_sale_status(HttpSession session, Integer productId, Integer status) {
        //判断用户是否登录
        //判断用户权限
        return productService.set_sale_status(productId, status);
    }


    /**
     * 商品详情
     */
    @RequestMapping("/detail.do")
    public ServerResponse detail(HttpSession session, Integer productId) {
        //判断用户是否登录
        //判断用户权限
        return productService.detail(productId);
    }

    /**
     * 查看商品列表
     */
    @RequestMapping(value = "/list.do")
    public ServerResponse list(HttpSession session,
                               @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        //判断用户是否登录
        //判断用户权限
        return productService.list(pageNum, pageSize);
    }

    /**
     * 商品搜索
     */
    @RequestMapping(value = "/search.do")
    public ServerResponse search(HttpSession session,
                                 @RequestParam(value = "productId", required = false) Integer productId,
                                 @RequestParam(value = "productName", required = false) String productName,
                                 @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENTUSER);
        if (userInfo == null) {
            return ServerResponse.serverResponseByError(Const.ReponseCodeEnum.NEED_LOGIN.getCode(), Const.ReponseCodeEnum.NEED_LOGIN.getDesc());
        }
        //判断用户权限
        return productService.search(productId, productName, pageNum, pageSize);
    }

}
