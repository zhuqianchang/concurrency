package indi.zqc.concurrency.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadExecutor
 */
@Slf4j
public class threadPoolExample3 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            final int index = i;
            executor.execute(() -> {
                log.info("{}", index);
            });
        }
        executor.shutdown();
    }
}
