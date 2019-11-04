package com.kp1nz.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kp1nz
 * @create 2019-01-11 14:46
 */
@Data
public class ShippingVO implements Serializable {

    private String receiverName;
    private String receiverPhone;
    private String receiverMobile;
    private String receiverProvince;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverZip;
}
