package com.multithreading;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author jh
 * @Description
 * @Date created in 14:59 2022/6/14
 */
public class demo {

    public void enableMultiThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

      /*  try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        try {
            for (int j = 0; j < 100; j++) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
/*                        if (j % 2 == 1) {
                            try {
                                Thread.currentThread().sleep(200000);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }*/
                        int v = (int)(Math.random() * 10);
                        if (v%2 == 1){
                            try {
                                Thread.currentThread().sleep(20000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        log.info("线程名{}，方法执行时间{},随机数{}", Thread.currentThread().getName(),format.format(new Date()),v);
                        System.out.println("线程名:"+Thread.currentThread().getName()+"，方法执行时间"+format.format(new Date())+",随机数+"+v);
//                            synchronized (proDataFeignService) {
//                                try {
//                                    proDataFeignService.wait(1000);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                            }


                    }
                });

            }
        } finally {
//            synchronized (proDataFeignService) {
//                proDataFeignService.notifyAll();
//            }
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

class MyTest {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }

        for (Integer i : arr) {
            if (i == 5) {
                arr.remove(i);
            } else {
                System.out.println(i);
            }
        }
    }
}
