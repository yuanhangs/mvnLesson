package com.annotation;

/**
 * @ClassName Animal
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/25
 * @Version V1.0
 **/
public  abstract  class Animal {
    public abstract  void play();
}

class Dog extends  Animal{

//    @SuppressWarnings()
    //重写父类的方法
    @Override
    public void play() {

    }

    @Deprecated
    public  String content;

    //这个方法已过时了！
    @Deprecated
    public void show(){

    }
}

class TestDog{
    public static void main(String[] args) {
//        new Dog().show();
        new Dog().hashCode();

    }
}