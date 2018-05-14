package com.ustc;

/**
 * @Author: AsmallCoder
 * @Description
 * @Date: Created in 10:57 2018/5/14 0014
 */

/**
 * 传统方式
 */

class benzCar{
    public void drive(){
        System.out.println("驾驶奔驰车");
    }
}

class bmwCar{
    public void drive(){
        System.out.println("驾驶宝马车");
    }
}

class client{
    public static void main(String[] args) {
        benzCar benzCar = new benzCar(); //客户需要知道怎么去创建一辆车，现在需要解耦，将创建的细节交给工厂实现
        bmwCar bmwCar = new bmwCar();
        benzCar.drive();
        bmwCar.drive();
    }
}

/**
 * 简单工厂模式：静态工厂方法模式
 */

/**
 * 抽象产品类
 */
interface car{
    public void drive();
}

/**
 * 具体产品类
 */
class benzCar1 implements car{
    @Override
    public void drive() {
        System.out.println("驾驶奔驰车");
    }
}
class bmwCar1 implements car{
    @Override
    public void drive() {
        System.out.println("...");
    }
}

/**
 * 工厂角色类
 */
class driveFactory{
    public static car driveCar(String name) throws Exception{
        if(name.equals("benzCar"))
            return new benzCar1();
        else if (name.equals("bmwCar"))
            return new bmwCar1();
        else
            throw new Exception();
    }
}

/**
 * 客户
 */
class client1 {
    public static void main(String[] args) throws Exception{
        //从工厂获取对象
        car car = driveFactory.driveCar("benzCar");
        //下命令开车
        car.drive();
    }
}

/**
 * 工厂方法模式：抽象工厂角色，具体工厂角色，抽象产品角色，具体产品角色
 * 缺点：对象数量增加
 */

/**
 * 抽象产品类
 */
abstract class car1{
    abstract void drive();
}

/**
 * 具体产品类
 */
class bmwCar2 extends car1{
    @Override
    void drive() {
        System.out.println("宝马车");
    }
}

/**
 * 抽象工厂类
 */
interface abstractFactory{
    public car1 driveCar();
}

/**
 * 具体工厂类
 */
class bmwCarFactory implements abstractFactory{
    @Override
    public car1 driveCar() {
        return new bmwCar2();
    }
}

/**
 * client
 */
class client2{
    private static car1 bmwCar;
    private static abstractFactory bmwcarFactory;

    public static void main(String[] args) {
        bmwcarFactory = new bmwCarFactory();
        bmwCar = bmwcarFactory.driveCar();
        bmwCar.drive();
    }
}

/**
 * 抽象工厂模式
 * 抽象工厂，具体工厂，抽象产品，具体产品
 */
//抽象产品,商务车
interface ICarA{
    public void drive();
}
//抽象产品，跑车
interface ICarB{
    public void drive();
}

//具体产品
class productA implements ICarA{
    @Override
    public void drive() {
        System.out.println("商务车");
    }
}

class productB implements ICarB{
    @Override
    public void drive() {
        System.out.println("跑车");
    }
}

class produceAFactory implements ICarA{
    @Override
    public void drive() {
        System.out.println("开商务车");
    }
}
class produceBFactory implements ICarB{
    @Override
    public void drive() {
        System.out.println("开跑车");
    }
}


//抽象工厂
abstract class abstractFactory2{
    abstract ICarA getProduct();
}

//具体工厂

class Factory1 extends abstractFactory2{
    @Override
    ICarA getProduct() {
        return null;
    }
}
//客户
class Client1{
    public static void main(String[] args) {
        abstractFactory2 Factory = new Factory1();
        ICarA productA = Factory.getProduct();
        productA.drive();
    }
}


public class factory {

}
