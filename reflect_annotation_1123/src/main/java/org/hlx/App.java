package org.hlx;

import pojo.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        getClass1();
//        getConstructor();
//        getField();
//        getMethod();
    }

    private static void getMethod() {
        try {
            //类对象
            Class<?> cl = Class.forName("pojo.Student");
            //获取所有的方法
            Method[] methods = cl.getDeclaredMethods();
            //循环
            for (int i = 0; i < methods.length; i++) {
//             参照：   public void show()
                String modify = Modifier.toString(methods[i].getModifiers());
                String type = methods[i].getReturnType().getName();
                String name = methods[i].getName();
                System.out.print(modify + " " + type + " " + name);
                System.out.print("(");

                //参数：（ String name,int age）
                Class<?> pars[] = methods[i].getParameterTypes();
                if (pars != null) {
                    for (int j = 0; j < pars.length; j++) {
                        String str = pars[j].getName() + " arg" + j;
                        System.out.print(str);
                        //判断加“，”
                        if (j < pars.length - 1) {
                            System.out.print(",");
                        }
                    }

                }
                //异常：  throws NumberFormatException, Exception
                Class<?> exs[] = methods[i].getExceptionTypes();
                for (int j = 0; j <exs.length ; j++) {
                     //????
                }

                 System.out.print(")");

                //换行
                System.out.println();
            }


            //单个方法的调用
            Object obj =cl.newInstance();
            //获得method对象 (无参数)
            Method method =cl.getDeclaredMethod("show");
            //调用
            Object ink= method.invoke(obj);


            //获得method对象 (有参数)
            Method method2 =cl.getDeclaredMethod("display", String.class, int.class);
            //调用
            Object ink2= method2.invoke(obj,"楼挺好",18);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getField() {
        try {
            //类对象
            Class<?> cl = Class.forName("pojo.Student");

//            1、通过Class对象获取Field 对象

            //只能公共的public
//            Field[] fields = cl.getFields();
            Field[] fields = cl.getDeclaredFields();
            //循环
            for (Field field : fields) {
//           效果：     private int age;
                String modfiy = Modifier.toString(field.getModifiers());
                String type = field.getType().getName();
                String name = field.getName();

//                System.out.println(modfiy+" "+type+" "+name);
            }

//            2、调用Field 对象的方法进行取值或赋值操作
            //private和protected赋值？可不可以呢？
            //获得字段名
            Field fieldName = cl.getDeclaredField("name");
//            java.lang.IllegalAccessException: Class org.hlx.App can not access a member of class pojo.Student with modifiers "private"
            //解决问题:给个访问权限
            fieldName.setAccessible(true);

            //设置值 new Student().setName("mike");
            //相当于实例化对象 ==>new Student()
            Object obj = cl.newInstance();
            fieldName.set(obj, "懒洋洋");
            System.out.println(fieldName.get(obj));

//            Field fieldAddress=cl.getDeclaredField("address");
//            System.out.println(fieldAddress.get(obj));

            //public 字段
            Field fieldCount = cl.getDeclaredField("count");
            System.out.println(fieldCount.get(obj));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getConstructor() {
        //        方法一：使用Class的newInstance()方法，仅适用于无参构造方法
        try {
            //1.获取Student类
            Class<?> cl = Class.forName("pojo.Student");

            //2.实例化对象
            Object obj = cl.newInstance();
            //强制类型转换
            Student stu = (Student) obj;

            //3.给属性赋值
            stu.setName("lth");
            stu.setAge(20);

            System.out.println(obj);


//       * 方法二：调用Constructor的newInstance()方法，适用所有构造方法
            Constructor cs = cl.getConstructor(new Class[]{String.class, int.class});
            //实例化对象
            Object objs = cs.newInstance("应天宇", 18);
            System.out.println(objs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getClass1() {
        //        获取 Class对象的方式 (3种）
        //1.对象.getClass()
        Class<?> cl1 = new App().getClass();

        //2.类.class
        Class<?> cl2 = App.class;

        //3.Class.forName()
        try {
            Class<?> cl3 = Class.forName("org.hlx.App");

            System.out.println(cl1);
            System.out.println(cl2);
            System.out.println(cl3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
