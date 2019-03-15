package com.neuedu.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author kp1nz
 * @create 2019-01-11 16:05
 */
@Data
public class CartOrderItemVO implements Serializable {

    private List<OrderItemVO> orderItemVOList;
    private String imageHost;
    private BigDecimal totalPrice;
}
