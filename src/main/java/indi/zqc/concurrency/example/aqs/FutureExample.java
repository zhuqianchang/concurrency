package indi.zqc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future
 */
@Slf4j
public class FutureExample {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(() -> {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "done";
        });
        log.info("do something in main");
        Thread.sleep(1000);
        String result = future.get();
        log.info("result is {}", result);
        executor.shutdown();
    }
}
