package org.hlx;

import java.util.Date;

public class SchuduleServer implements Runnable {
    @Override
    public void run() {
        //死循环
        while (true) {
            System.out.println("开始"+new Date()+"扫描!");
            try {
                //休眠
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
