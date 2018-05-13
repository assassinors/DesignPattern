package com.ustc;

/**
 * @Author: AsmallCoder
 * @Description
 * @Date: Created in 21:36 2018/5/13 0013
 */

/**
 * 对象的创建模式，内部表象（internal representation）和生产过程分开
 * 工厂模式：如何获取实例对象
 * 建造者模式：如何建造实例对象
 * 对象：有待建造，建造者返回给客户端一个建造完毕的对象
 * 四个角色：抽象建造者，具体建造者，导演者：调用具体建造者去创建产品对象，产品
 */

/**
 * 抽象建造者
 */
public interface Builder{
    //零件一的建造方法
    public void buildPart1();
    //零件二的建造方法
    public void buildPart2();
    //返回产品的方法
    public Product retrieveResult();
}

/**
 * 具体建造者
 */
class ConcreteBuilder implements Builder{
    private Product product = new Product();
    //构建第一个零件
    @Override
    public void buildPart1() {
        product.setPart1("A");
    }
    //构建第二个零件
    @Override
    public void buildPart2() {
        product.setPart2("B");
    }
    //返回产品
    @Override
    public Product retrieveResult() {
        return product;
    }
}
/**
 * 导演者
 */
class Director{
    //持有建造者对象
    private Builder builder;

    //构造方法传入建造者对象
    public Director(Builder builder){
        this.builder = builder;
    }

    public void construct(){
        builder.buildPart1();
        builder.buildPart2();
    }
}
/**
 * 产品对象
 */

class Product{
    private String part1;
    private String part2;

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart1() {
        return part1;

    }
}


class Client{
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();

        Product product = builder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());

    }
}
