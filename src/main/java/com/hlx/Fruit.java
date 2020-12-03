package com.hlx;

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

class Apple implements  Fruit{

    @Override
    public void eat() {
        System.out.println("Apple");
    }
}

class Orange implements  Fruit{

    @Override
    public void eat() {
        System.out.println("Orange");
    }
}

class Factory{
    //可以不修改工程类的情况可以添加多个子类
    public static Fruit getInstance (String className){
        Fruit f = null;
        try {
            //原来Object +>Fruit 强制类型转换
            f= (Fruit) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}

class Test2{
    public static void main(String[] args) {
        Factory.getInstance("com.hlx.Apple").eat();
        Factory.getInstance("com.hlx.Orange").eat();
    }
}