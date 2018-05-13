package com.ustc;

/**
 * @Author:AsmllCoder
 * @Description
 * @Date: Created in 19:20 2018/5/13 0013
 */

/*
 *懒汉式 ：缺点：线程不安全，即当多个线程同时到达getInstance()方法时，有可能会实例化多个类对象
 */
public class Singleton {   //java反射机制能够实现实例化构造方法为private的类

    private Singleton(){
    }

    private static Singleton singleton = null;

    public static Singleton getInstance(){
        if(singleton == null)
            singleton = new Singleton();
        return singleton;
    }
}

/*
 * 懒汉式改进1：getInstance()方法加上同步关键字
 */
class Singleton1{
    private Singleton1(){
    }
    private static Singleton1 singleton1 = null;
    public static synchronized Singleton1 getInstance(){ //getInstance必须为静态的，否则会调用不到
        if (singleton1 == null)
            singleton1 = new Singleton1();
        return singleton1;
    }
}

/*
 *改进2:双重检查锁定
 */
class Singleton2{
    private Singleton2(){}

    private static Singleton2 singleton2 = null;

    public static Singleton2 getInstance(){
        //先检查实例是否存在，如果存在则不进入同步块
        if(singleton2 == null){
            synchronized (Singleton2.class){
                //再次检查，是因为上锁之后可能其他线程在synchronized外面排队，
                // 等第一个实例创建完之后，其他线程进来了，如果这时候不判断实例是否为空就创建，
                // 就可能又创建一个实例，违背了单例模式了
                if (singleton2 == null){
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}

/*
    静态内部类，由虚拟机来控制线程安全
 */
class Singleton3 {
    private Singleton3(){}

    private static class SingletonHolder{
        private static Singleton3 singleton3 = new Singleton3();
    }
    public Singleton3 getInstance(){
        return SingletonHolder.singleton3;
    }
}

/**
 * 饿汉式单例模式,自行实例化,天生线程安全
 */

class EagerSingleton{
    private static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){
    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}

/**
 * 枚举来实现单例模式
 */
enum Singleton4{
    /**
     * 定义一个枚举元素，代表Singleton的一个实例
     */
    INSTANCE1,INSTANCE2;

    private Singleton4(){}
}