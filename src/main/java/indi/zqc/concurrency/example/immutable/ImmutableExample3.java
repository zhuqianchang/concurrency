package indi.zqc.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import indi.zqc.concurrency.annotation.ThreadSafe;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 不可变对像
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private final static List<Integer> list = ImmutableList.of(1, 2, 3);

    private final static Set<Integer> set = ImmutableSet.copyOf(list);

    private final static Map<Integer, Integer> map = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3, 4).put(5, 6).build();

    public static void main(String[] args) {
        list.add(4); // 不能修改
        set.add(4); // 不能修改
        map.put(1, 3); // 不能修改
    }
}
