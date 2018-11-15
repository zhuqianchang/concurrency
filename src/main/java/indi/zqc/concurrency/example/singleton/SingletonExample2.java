package indi.zqc.concurrency.example.singleton;

import indi.zqc.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 * 实例在类加载时创建
 */
@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2() {
    }

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }
}
