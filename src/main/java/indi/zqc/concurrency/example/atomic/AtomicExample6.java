package indi.zqc.concurrency.example.atomic;

import indi.zqc.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@ThreadSafe
public class AtomicExample6 {

    // 总请求数
    private static int clientTotal = 5000;

    // 并发线程数
    private static int threadTotal = 200;

    // 最终值
    private static AtomicBoolean isHappen = new AtomicBoolean(false);

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
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("isHappen:{}", isHappen.get());
    }

    private static void test() {
        if (isHappen.compareAndSet(false, true)) {
            log.info("execute");
        }
    }
}
