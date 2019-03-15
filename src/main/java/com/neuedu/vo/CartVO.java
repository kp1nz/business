package com.neuedu.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车实体类
 * @author kp1nz
 * @create 2019-01-09 21:16
 */
@Data
public class CartVO implements Serializable {
    //购物信息集合
    private List<CartProductVO> cartProductVOList;
    //是否全选
    private boolean isallchecked;
    //总价格
    private BigDecimal carttotalprice;
}
