package com.neuedu.mq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者-投递消息
 * @author kp1nz
 * @create 2019-02-21 19:48
 */
public class Producer {

    public static void main(String[] args) {
        //step1:ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.105.33.241");
        connectionFactory.setPort(5762);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        //step2:Connection
        Connection connection = null;
        Channel channel= null;
        try {
            connection = connectionFactory.newConnection();
            //step3:Channel
            channel = connection.createChannel();
            String routingkey="test";
            for(int i= 0;i<5;i++){
                String msg = "hello,rabbitmq!"+i;
                //step4:发消息
                channel.basicPublish("",routingkey,null,msg.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            try {
                channel.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }

}
