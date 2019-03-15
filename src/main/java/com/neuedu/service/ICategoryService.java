package com.neuedu.service;

import com.neuedu.common.ServerResponse;

/**
 * @author kp1nz
 * @create 2019-01-07 15:04
 */
public interface ICategoryService {
    /**
     * 获取商品子类别
     */
    ServerResponse get_category(Integer categoryId);
    /**
     * 增加商品类别
     */
    ServerResponse add_category(Integer parentId,String categoryName);
    /**
     * 修改节点
     */
    ServerResponse set_category_name(Integer categoryId, String categoryName);
    /**
     * 获取当前分类id及递归子节点categoryId
     */
    ServerResponse get_deep_category(Integer categoryId);
}
