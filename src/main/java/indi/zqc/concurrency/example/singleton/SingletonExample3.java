package indi.zqc.concurrency.example.singleton;

import indi.zqc.concurrency.annotation.NotRecommand;
import indi.zqc.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式
 * 实例在第一次使用时创建
 */
@ThreadSafe
@NotRecommand
public class SingletonExample3 {

    private SingletonExample3() {
    }

    private static SingletonExample3 instance = null;

    public synchronized static SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
