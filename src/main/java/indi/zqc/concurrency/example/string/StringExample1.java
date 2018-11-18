package indi.zqc.concurrency.example.string;

import indi.zqc.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * StringBuilder
 */
@Slf4j
@NotThreadSafe
public class StringExample1 {

    // 总请求数
    private static int clientTotal = 5000;

    // 并发线程数
    private static int threadTotal = 200;

    // 最终值
    private static StringBuilder value = new StringBuilder();

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
                    update();
                    semaphore.release();
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}", value.length());
    }

    private static void update() {
        value = value.append("1");
    }
}
