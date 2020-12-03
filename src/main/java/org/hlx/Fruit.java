package org.hlx;

/**
 * @ClassName Fruit
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/25
 * @Version V1.0
 **/
public interface Fruit {
    void eat();
}

class Apple implements Fruit {

    @Override
    public void eat() {
        System.out.println("Apple");
    }
}

class Orange implements Fruit {

    @Override
    public void eat() {
        System.out.println("Orange");
    }
}

