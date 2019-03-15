package com.neuedu.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者-消费消息
 * @author kp1nz
 * @create 2019-02-21 19:48
 */
public class Cosumer {
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
            //step4:声明队列
            //默认寻找和routingkey相同的队列
            String queueName="test";
            channel.queueDeclare(queueName,true,false,false,null);
            //step5:声明一个消费者
            QueueingConsumer queueingConsumer =new QueueingConsumer(channel);
            channel.basicConsume(queueName,true,queueingConsumer);
            while (true) {
                //step6:消费者取消息
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
                String msg = new String(delivery.getBody());
                System.out.println("Comsume=="+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
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
