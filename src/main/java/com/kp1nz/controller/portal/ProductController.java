package com.kp1nz.controller.portal;

import com.kp1nz.common.ServerResponse;
import com.kp1nz.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kp1nz
 * @create 2019-01-09 19:46
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    IProductService productService;
    /**
     * 前台_商品详情
     */
    @RequestMapping(value = "detail.do")
    public ServerResponse detail(Integer productId){
        return productService.detail_protal(productId);
    }

    /**
     * 前台_搜索商品并排序
     */
    @RequestMapping(value = "/list.do")
    public ServerResponse list(@RequestParam(required = false) Integer categoryId,
                               @RequestParam(required = false) String keyword,
                               @RequestParam(required = false,defaultValue = "1")Integer pageNum,
                               @RequestParam(required = false,defaultValue = "10")Integer pageSize,
                               @RequestParam(required = false,defaultValue = "")String orderBy){
        return  productService.list_portal(categoryId,keyword,pageNum,pageSize,orderBy);
    }
}
