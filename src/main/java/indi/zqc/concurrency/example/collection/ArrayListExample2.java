package indi.zqc.concurrency.example.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayList
 */
@Slf4j
public class ArrayListExample2 {

    // java.util.ConcurrentModificationException
    private static void test1(List<Integer> list) {
        for (Integer i : list) {
            if (i.equals(3)) {
                list.remove(i);
            }
        }
    }

    private static void test2(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals(3)) {
                it.remove();
            }
        }
    }

    private static void test3(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(3)) {
                list.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        test1(list);
        test2(list);
        test3(list);
    }
}
