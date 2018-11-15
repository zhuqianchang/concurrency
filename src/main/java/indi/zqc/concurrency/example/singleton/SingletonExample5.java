package indi.zqc.concurrency.example.singleton;

import indi.zqc.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 * 实例在类加载时创建
 */
@ThreadSafe
public class SingletonExample5 {

    private SingletonExample5() {
    }

    // 注意2个代码块的顺序

    // 1
    private static SingletonExample5 instance = null;

    // 2
    static {
        instance = new SingletonExample5();
    }

    public static SingletonExample5 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(instance);
    }
}
