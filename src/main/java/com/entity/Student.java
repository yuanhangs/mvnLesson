package com.entity;

/**
 * @ClassName net.pojo.Student
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/24
 * @Version V1.0
 **/
public class Student {
    //属性字段
    private int age=10;
    private String name;

    protected String address;
    public double count;



    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void show() throws  NumberFormatException,Exception{
        System.out.println("this is a reflect Method!");
    }

    public void show2(int age, String name) {
        System.out.println("Java 反射机制 - 调用某个类的方法2.");
        System.out.println("age -> " + age + ". name -> " + name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
