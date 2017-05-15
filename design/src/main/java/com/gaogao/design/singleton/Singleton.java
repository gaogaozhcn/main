package com.gaogao.design.singleton;

/**
 * Created by gaohaiming on 16/9/10.
 */
public class Singleton {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton instance = null;

    /* 私有构造方法，防止被实例化 */
    private Singleton() {
    }

    /* 静态工厂方法，创建实例 */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }



    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

    /* 获取实例 */
    public static Singleton getInstance2() {
        return SingletonFactory.instance;
    }


    /** 此处的锁只会被调用一次减少,由于锁带来的性能损失**/
    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Singleton();
        }
    }
    /**增加锁防止多线程情况下创建多个实例**/
    public static Singleton getInstance3() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return instance;
    }
}
