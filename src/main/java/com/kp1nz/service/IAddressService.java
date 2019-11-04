package com.kp1nz.service;

import com.kp1nz.common.ServerResponse;
import com.kp1nz.pojo.Shipping;

/**
 * @author kp1nz
 * @create 2019-01-10 20:06
 */
public interface IAddressService {
    /**
     * 添加地址
     */
    ServerResponse add(Integer userId, Shipping shipping);

    /**
     * 删除地址
     */
    ServerResponse del(Integer userId, Integer shippingId);

    /**
     * 更新地址
     */
    ServerResponse update(Shipping shipping);

    /**
     * 查看选中地址
     */
    ServerResponse select(Integer shippingId);

    /**
     * 分页查询地址列表
     */
    ServerResponse list(Integer pageNum, Integer pageSize);
}
