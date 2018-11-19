package indi.zqc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;

@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask(() -> {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "done";
        });
        new Thread(futureTask).start();
        log.info("do something in main");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("result is {}", result);
    }

}
