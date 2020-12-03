package net.hlx;

import java.util.Date;

/**
 * 父类
 */
public abstract class Pet {
    public  abstract  void show();
}

//子类
class Cat extends  Pet{

    //重写：注解
    //注释:代码说明！
    @Override
    public void show() {
        System.out.println("猫在玩！");
    }

    //过时：注解
    @Deprecated
    public void test(){

    }

   //不要检查 （框架）
    @SuppressWarnings("hello!")
     String name;
}

class TestCat{
    public static void main(String[] args) {
        new Cat().test();

//        new Date().getDate()

        new Cat().name="ss";

    }
}