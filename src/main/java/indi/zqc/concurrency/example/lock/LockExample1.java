package indi.zqc.concurrency.example.lock;

import indi.zqc.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * synchronized
 */
@Slf4j
@ThreadSafe
public class LockExample1 {

    // 总请求数
    private static int clientTotal = 5000;

    // 并发线程数
    private static int threadTotal = 200;

    // 最终值
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 信号量
        Semaphore semaphore = new Semaphore(threadTotal);
        // 计数器
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }

    private static synchronized void add() {
        count++;
    }
}
