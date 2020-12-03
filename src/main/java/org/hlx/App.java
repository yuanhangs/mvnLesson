package org.hlx;

import com.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        one();
//        getConstructor();
//         getField();
//        getMethod();

        try {
            Class<?> cl = Class.forName("com.entity.Student");
            //写方法名
            Method method =cl.getMethod("show2", int.class, String.class);
            //调用方法
            Object obj= method.invoke(cl.newInstance(),20,"hello");
            System.out.println(obj);

        } catch (Exception ex) {

        }

    }

    private static void getMethod() {
        try {
            Class<?> cl = Class.forName("com.entity.Student");
            Method[] methods = cl.getDeclaredMethods();
//            for(Method method :methods){
//
//               // System.out.println(method.getName());
//            }

            for (int i = 0; i < methods.length; i++) {

                Class<?> strReturn = methods[i].getReturnType();
                Class<?> parameters[] = methods[i].getParameterTypes();
                //修饰符
                int num = methods[i].getModifiers();
                System.out.print(Modifier.toString(num) + " ");
                System.out.print(strReturn.getName() + " ");
                System.out.print(methods[i].getName() + " ");

                System.out.print("(");
                //参数
                for (int j = 0; j < parameters.length; j++) {
                    System.out.println(parameters[j].getName() + " " + "arg" + j);
                    if (j < parameters.length - 1) {
                        System.out.print(",");
                    }
                }
                Class<?> exs[] = methods[i].getExceptionTypes();

                //判断
                if (exs.length > 0) {
                    System.out.print(") throws ");
                    //循环
                    for (int j = 0; j < exs.length; j++) {
                        System.out.print(exs[j].getName() + " ");
                        if (j < exs.length - 1) {
                            System.out.print(",");
                        }
                    }
                } else {
                    System.out.print(")");
                }

                //换行
                System.out.println();

            }

        } catch (Exception ex) {

        }
    }

    private static void getField() {
        try {
            Class<?> cl = Class.forName("com.entity.Student");

            //只能访问公共的
//            Field[]  fields=cl.getFields();
            Field[] fields = cl.getDeclaredFields();
            //
            for (Field fi : fields) {
//                private String name;
                String pri = Modifier.toString(fi.getModifiers());
                //
                String type = fi.getType().getName();
                //
                String name = fi.getName();

                System.out.println(pri + "\t" + type + "\t" + name);
            }


//        可以修改权限来给private,protected赋值
            //创建对象  Student obj = new Student();
            Object obj = cl.newInstance();
            //获得属性
            Field field = cl.getDeclaredField("name");
            field.setAccessible(true);
//            java.lang.IllegalAccessException: Class org.hlx.App can not access a member of class com.entity.Student with modifiers "private"
            //直接赋值  obj具体对象  obj.setName(name);
            field.set(obj, "蓝牙");
            System.out.println(field.get(obj));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getConstructor() {
        //1 class
        try {
            Class<?> cl = Class.forName("com.entity.Student");
            //2>对象
            Object obj = cl.newInstance();
            //3>强制类型转换
            Student stu = (Student) obj;
            stu.setAge(20);
            stu.setName("mike");
            System.out.println(obj);


            //构造方法的参数:类的类型int.class,Double.class...
            Constructor ct = cl.getConstructor(new Class[]{int.class, String.class});

            //实例化对象
            Object objs = ct.newInstance(new Object[]{18, "Mathilda"});

            System.out.println(objs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void one() {
        //1. ？任意类型  Class<String> 字符串型
        Class<?> cl = new App().getClass();

        Class<?> c2 = App.class;

        try {
            Class<?> c3 = Class.forName("org.hlx.App");

            System.out.println(cl);
            System.out.println(c2);
            System.out.println(c3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
