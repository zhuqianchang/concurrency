package indi.zqc.concurrency.example.datetime;

import indi.zqc.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * SimpleDateFormat线程不安全，使用区别变量
 */
@Slf4j
@ThreadSafe
public class DateFormatExample2 {

    // 总请求数
    private static int clientTotal = 5000;

    // 并发线程数
    private static int threadTotal = 200;

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
    }

    private static void update() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            dateFormat.parse("2018-11-17");
        } catch (ParseException e) {
            log.info(e.getMessage(), e);
        }
    }
}
