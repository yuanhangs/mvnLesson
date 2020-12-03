package org.hlx;

import java.util.Date;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println(new Date()+"打印！！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
