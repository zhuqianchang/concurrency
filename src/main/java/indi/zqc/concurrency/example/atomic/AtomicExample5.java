package indi.zqc.concurrency.example.atomic;

import indi.zqc.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    private volatile int count = 100;

    public static void main(String[] args) {

        AtomicExample5 example = new AtomicExample5();
        if (updater.compareAndSet(example, 100, 120)) {
            log.info("update success, count:{}", example.getCount());
        }

        if (updater.compareAndSet(example, 100, 120)) {
            log.info("update success, count:{}", example.getCount());
        } else {
            log.info("update failure, count:{}", example.getCount());
        }
    }
}
