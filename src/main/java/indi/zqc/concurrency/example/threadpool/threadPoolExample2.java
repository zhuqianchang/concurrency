package indi.zqc.concurrency.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadExecutor
 */
@Slf4j
public class threadPoolExample2 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            final int index = i;
            executor.execute(() -> {
                log.info("{}", index);
            });
        }
        executor.shutdown();
    }
}
