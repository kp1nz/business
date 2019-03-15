package com.neuedu.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author kp1nz
 * @create 2019-01-08 14:51
 */
@Data
public class ProductDetailVO implements Serializable {
    private Integer id;
    private Integer categoryId;
    private Integer parentCategoryId;
    private String name;
    private String subtitle;
    private String imageHost;
    private String mainImage;
    private String subImages;
    private String detail;
    private BigDecimal price;
    private Integer stock;
    private Integer status;
    private String createTime;
    private String updateTime;
}
