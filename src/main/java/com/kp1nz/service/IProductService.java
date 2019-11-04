package com.kp1nz.service;

import com.kp1nz.common.ServerResponse;
import com.kp1nz.pojo.Product;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author kp1nz
 * @create 2019-01-08 14:00
 */
public interface IProductService {
    /**
     * 新增or更新商品
     */
    ServerResponse saveOrUpdate(Product product);

    /**
     * 商品上下架
     * @param status 商品状态
     */
    ServerResponse set_sale_status(Integer productId, Integer status);

    /**
     * 后台_商品详情
     */
    ServerResponse detail(Integer productId);

    /**
     * 后台_商品列表,分页
     */
    ServerResponse list(Integer pageNum, Integer pageSize);

    /**
     * 后台_商品搜索
     */
    ServerResponse search(Integer productId, String productName, Integer pageNum, Integer pageSize);
    /**
     * 图片上传
     */
    ServerResponse upload(MultipartFile file,String path);
    /**
     * 前台_商品详情
     */
    ServerResponse detail_protal(Integer productId);
    /**
     * 前台_搜索商品并排序
     * @param orderBy 排序字段
     */
    ServerResponse list_portal(Integer categoryId,String keyword,Integer pageNum,Integer pageSize,String orderBy);
}
