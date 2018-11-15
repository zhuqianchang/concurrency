package indi.zqc.concurrency.example.singleton;

import indi.zqc.concurrency.annotation.NotThreadSafe;

/**
 * 懒汉模式
 * 实例在第一次使用时创建
 */
@NotThreadSafe
public class SingletonExample1 {

    private SingletonExample1() {
    }

    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
