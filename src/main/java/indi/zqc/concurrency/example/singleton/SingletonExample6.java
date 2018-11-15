package indi.zqc.concurrency.example.singleton;

import indi.zqc.concurrency.annotation.Recommand;
import indi.zqc.concurrency.annotation.ThreadSafe;

/**
 * 枚举模式
 */
@ThreadSafe
@Recommand
public class SingletonExample6 {

    private SingletonExample6() {
    }

    public static SingletonExample6 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample6 instance;

        // JVM保证只执行一次
        Singleton() {
            instance = new SingletonExample6();
        }

        public SingletonExample6 getInstance() {
            return instance;
        }
    }
}
