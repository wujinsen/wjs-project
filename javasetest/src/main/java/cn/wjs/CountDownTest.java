package cn.wjs;

import java.util.concurrent.CountDownLatch;

public class CountDownTest {
    public static void main(String[] args) {
        CountDownTest();
    }

    private static void CountDownTest(){
        int i = 3;
        final CountDownLatch countDownLatch = new CountDownLatch(i);
        new Thread(new Runnable(){
            public void run(){
                System.out.println("D is waiting for other three threads");
                try {
                    countDownLatch.await();
                    System.out.println("All done, D starts working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for(char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(tN + " is working");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tN + " finished");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
//    private static void runDAfterABC() {
//        int worker = 3;
//        final CountDownLatch countDownLatch = new CountDownLatch(worker);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("D is waiting for other three threads");
//                try {
//                    countDownLatch.await();//知道计数器变成0才执行
//                    System.out.println("All done, D starts working");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        for (char threadName='A'; threadName <= 'C'; threadName++) {
//            final String tN = String.valueOf(threadName);
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(tN + " is working");
//                    try {
//                        Thread.sleep(100);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(tN + " finished");
//                    countDownLatch.countDown();
//                }
//            }).start();
//        }
//    }
}
