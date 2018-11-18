package indi.zqc.concurrency.example.immutable;

import com.google.common.collect.Maps;
import indi.zqc.concurrency.annotation.NotThreadSafe;
import indi.zqc.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * final
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        map.put(1, 3); // final 还是能修改
        log.info("{}", map.get(1));
    }
}
