package indi.zqc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore
 */
@Slf4j
public class SemaphoreExample4 {

    private static final int threadCount = 20;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    if (semaphore.tryAcquire(3, 5, TimeUnit.SECONDS)) { // 尝试等待获取许可
                        test(threadNum);
                        semaphore.release(3); // 释放多个许可
                    }
                } catch (Exception e) {
                    log.info(e.getMessage(), e);
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int i) throws Exception {
        log.info("{}", i);
        Thread.sleep(1000);
    }
}
