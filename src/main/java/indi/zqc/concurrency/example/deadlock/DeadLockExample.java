package indi.zqc.concurrency.example.deadlock;

import lombok.extern.slf4j.Slf4j;

/**
 * DeadLock
 */
@Slf4j
public class DeadLockExample implements Runnable {

    private int flag = 0;

    private static Object o1 = new Object();

    private static Object o2 = new Object();

    @Override
    public void run() {
        if (flag == 0) {
            synchronized (o1) {
                log.info("flag : {}", flag);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    log.info("0");
                }
            }
        }

        if (flag == 1) {
            synchronized (o2) {
                log.info("flag : {}", flag);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    log.info("1");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLockExample example1 = new DeadLockExample();
        DeadLockExample example2 = new DeadLockExample();
        example1.flag = 0;
        example2.flag = 1;
        new Thread(example1).start();
        new Thread(example2).start();
    }
}
