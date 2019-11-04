package com.kp1nz.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author kp1nz
 * @create 2019-01-11 15:04
 */
@Data
public class OrderVO implements Serializable {
    private Long orderNo;
    private BigDecimal payment;
    private Integer paymentType;
    private String paymentTypeDesc;
    private Integer postage;
    private Integer status;
    private String statusDesc;
    private String paymentTime;
    private String sendTime;
    private String endTime;
    private String closeTime;
    private String createTime;

    private List<OrderItemVO> orderItemVoList;
    private String  imageHost;
    private Integer shippingId;
    private String receiverName;
    private ShippingVO shippingVo;
}

