package com.kp1nz.controller.common.scheduler;

import com.kp1nz.service.IOrderService;
import com.kp1nz.utils.PropertiesUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时关闭订单
 * @author kp1nz
 * @create 2019-01-18 12:36
 */
@Component
public class CloseOrder {
    @Autowired
    IOrderService orderService;

    //@Scheduled(fixedRate = 1000)
    @Scheduled(cron = "0 */1 * * * *")
    public void closeOrder(){
        System.out.println("scan overtime order...");
        Integer hour = Integer.parseInt(PropertiesUtils.readByKey("close.order.time"));
        String date = com.kp1nz.utils.DateUtils.dateToStr(DateUtils.addHours(new Date(), -hour));
        orderService.closeOrder(date);
    }

}
