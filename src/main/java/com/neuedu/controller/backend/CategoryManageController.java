package com.neuedu.controller.backend;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 后台类别管理
 *
 * @author kp1nz
 * @create 2019-01-07 14:49
 */
@RestController
@RequestMapping(value = "/manage/category")
public class CategoryManageController {

    @Autowired
    ICategoryService categoryService;

    /**
     * 获取商品子类别
     */
    @RequestMapping(value = "/get_category.do")
    public ServerResponse get_category(HttpSession session, Integer categoryId) {

        //判断用户是否登录
        //判断用户权限
        return categoryService.get_category(categoryId);
    }


    /**
     * RESTful风格架构
     */
    @RequestMapping(value = "/get_category/{categoryId}")
    public ServerResponse get_category_restful(HttpSession session, @PathVariable(value = "categoryId") Integer categoryId) {

        //判断用户是否登录
        //判断用户权限
        return categoryService.get_category(categoryId);
    }

    /**
     * 增加商品类别
     */
        @RequestMapping(value = "/add_category.do")
    public ServerResponse add_category(HttpSession session,
                                       @RequestParam(required = false,defaultValue = "0") Integer parentId,
                                       String categoryName){
        //判断用户是否登录
        //判断用户权限
        return  categoryService.add_category(parentId,categoryName);
    }
    /**
     * 修改商品类别
     */
    @RequestMapping(value = "/set_category_name.do")
    public ServerResponse set_category_name(HttpSession session, Integer categoryId, String categoryName){
        //判断用户是否登录
        //判断用户权限
        return  categoryService.set_category_name(categoryId,categoryName);
    }
    /**
     * 获取当前分类id及递归子节点categoryId
     */
    @RequestMapping(value = "/get_deep_category.do")
    public ServerResponse get_deep_category(HttpSession session, Integer categoryId){
        //判断用户是否登录
        //判断用户权限
        return  categoryService.get_deep_category(categoryId);
    }
}
