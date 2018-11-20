package indi.zqc.concurrency.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool
 */
@Slf4j
public class threadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        executor.schedule(() -> {
            log.info("running");
        }, 1, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(() -> {
            log.info("running");
        }, 1, 1, TimeUnit.SECONDS);
    }
}
