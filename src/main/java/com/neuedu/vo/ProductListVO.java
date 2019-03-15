package com.neuedu.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author kp1nz
 * @create 2019-01-08 16:15
 */
@Data
public class ProductListVO implements Serializable {

    private Integer id;
    private Integer categoryId;
    private String  name;
    private String  subtitle;
    private Integer status;
    private String  mainImage;
    private BigDecimal price;
}
