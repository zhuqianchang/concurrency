package indi.zqc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * CyclicBarrier
 */
@Slf4j
public class CyclicBarrierExample2 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            int threadNum = i;
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            });
        }
    }

    private static void race(int threadNum) throws Exception {
        log.info("{} is ready", threadNum);
        try {
            cyclicBarrier.await(3000, TimeUnit.MILLISECONDS);
        } catch (BrokenBarrierException | TimeoutException e) {

        }
        log.info("{} is continue", threadNum);
    }
}
