package org.hlx;


public class TestFactory {

    public static void main(String[] args) {
        FruitFactory.getInstance("org.hlx.Apple").eat();
        FruitFactory.getInstance("org.hlx.Orange").eat();
    }

}

class FruitFactory{
    //可以不修改工程类的情况可以添加多个子类
    public static Fruit getInstance(String  type) {
      Fruit fruit =null;
        try {
            //实例化子类对象
            fruit= (Fruit) Class.forName(type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}