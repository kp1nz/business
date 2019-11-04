package com.kp1nz.test;

import lombok.Data;

/**
 * 生产者消费者模型
 * @author kp1nz
 * @create 2019-01-24 10:49
 */
public class ProducterCustomerTest {

    public static void main(String[] args) {
        PanZi panZi = new PanZi();
        Customer customer = new Customer(panZi);
        Producter producter = new Producter(panZi);
        Thread thread_c = new Thread(customer);
        Thread thread_p = new Thread(producter);
        thread_p.start();
        thread_c.start();
    }

    static class Customer implements Runnable {
        private PanZi panZi;

        public Customer(PanZi panZi) {
            this.panZi = panZi;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("消费者吃了第" + i + "个包子");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                panZi.pull();
            }
        }
    }

    static class Producter implements Runnable {
        private PanZi panZi;

        public Producter(PanZi panZi) {
            this.panZi = panZi;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                BaoZi baoZi = new BaoZi(i);
                System.out.println("生产者做了第" + i + "个包子");
                panZi.push(baoZi);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class PanZi {
        private BaoZi[] baoZis = new BaoZi[10];
        private int index;

        public synchronized void push(BaoZi baoZi) {

            while (index > baoZis.length) {
                System.out.println(index);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notify();
            baoZis[index] = baoZi;
            index++;
        }

        public synchronized BaoZi pull() {
            while (index <= 0) {

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.notify();
            index--;
            BaoZi baoZi = baoZis[index];
            return baoZi;
        }

    }

    @Data
    static
    class BaoZi {
        private int id;

        public BaoZi(int id) {
            this.id = id;
        }
    }
}
