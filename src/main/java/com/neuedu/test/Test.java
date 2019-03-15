package com.neuedu.test;

import com.alipay.demo.trade.config.Configs;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import com.neuedu.utils.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @author kp1nz
 * @create 2019-01-05 13:53
 */
public class Test {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("1");
        };
        runnable.run();
    }


    @Autowired
    IProductService productService;


    @org.junit.Test
    public void tt() {
        Product product = new Product();
        product.setId(2);
//        product.setCategoryId(9);
//        product.setName("好看的卫衣");
        product.setSubtitle("這是衛衣ooo");
//        product.setDetail("棉");
//        product.setPrice(BigDecimal.valueOf(999));
//        product.setStock(3);
        product.setStatus(1);

//        productService.saveOrUpdate(product);
    }


    @org.junit.Test
    public void tttt() {
//        long l = System.nanoTime();
//        int a = 2 ;
//        a = a <<16;
//        long l1 = System.nanoTime();
//        System.out.println(a);
//        System.out.println(l1-l);
//        System.out.println("----------------------");
//        long l2 = System.nanoTime();
//        int a1 = 2 ;
//        a1 = a1 <<8<<8;
//        long l3 = System.nanoTime();
//        System.out.println(a);
//        System.out.println(l3-l2);
//        System.out.println("----------------------");
//        long l4 = System.nanoTime();
//        int a2 = 2 ;
//        a2 = a2 <<16;
//        long l5 = System.nanoTime();
//        System.out.println(a);
//        System.out.println(l5-l4);
//        System.out.println("----------------------");
//        int b = 2;
//        for (int count = 0;count<16;count++){
//            b*=2;
//        }
//        System.out.println(b);

        long l = System.nanoTime();
        int a = 2;
        a = a << 16;
        long l1 = System.nanoTime();
        System.out.println(a);
        System.out.println(l1 - l);
        System.out.println("----------------------");
        long l2 = System.nanoTime();
        int a1 = 4;
        a1 = a1 << 15;
        long l3 = System.nanoTime();
        System.out.println(a);
        System.out.println(l3 - l2);
        System.out.println("----------------------");


    }

    @org.junit.Test
    public void ddd() {
        System.out.println(5.0 / 2);
    }


    @org.junit.Test
    public void a() {
        int[] a = {1, 2};
        int x;
        for (int arr : a
        ) {
            System.out.println(a);
        }
    }

    @org.junit.Test
    public void calendar() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();//获得一个日历的实例
        System.out.println(simpleDateFormat.format(date));
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}
