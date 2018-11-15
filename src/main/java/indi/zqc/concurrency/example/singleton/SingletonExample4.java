package indi.zqc.concurrency.example.singleton;

import indi.zqc.concurrency.annotation.NotRecommand;
import indi.zqc.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式
 * 实例在第一次使用时创建
 */
@ThreadSafe
public class SingletonExample4 {

    private SingletonExample4() {
    }

    // volatile 静止指令重排
    private volatile static SingletonExample4 instance = null;

    public static SingletonExample4 getInstance() {
        if (instance == null) {
            // 同步锁
            synchronized (SingletonExample2.class) {
                // 双重检查机制
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
