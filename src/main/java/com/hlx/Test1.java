package com.hlx;

import com.entity.Student;

import java.lang.reflect.*;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/25
 * @Version V1.0
 **/
public class Test1 {
    public static void main(String[] args) throws Exception {
//        getClasses();
        getConstructor();
//        getFileds();
//        getMethods();

    }

    private static void getMethods() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //使用反射执行动态方法
        Class<?> class1 = Class.forName("com.entity.Student");

        //获得所有的方法
        Method[] methods = class1.getDeclaredMethods();
        //遍历
//        for (Method me:
//                methods ) {
//            String name = me.getName();
//            System.out.println(name);
//        }
        for (int i = 0; i < methods.length; ++i) {
            Class<?> returnType = methods[i].getReturnType();
            Class<?> para[] = methods[i].getParameterTypes();
            int temp = methods[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(methods[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = methods[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }


        //1.无参数无返回
        //方法对象method
        Method method = class1.getMethod("show");

//    具体对象
        Object obj = class1.newInstance();
        //调用
//        method.invoke(obj);


        //2.有参数无返回
        Method method2 = class1.getMethod("show2", int.class, String.class);
//        method2.invoke(obj,20,"mikes");

        //3.无参数有返回
        Method method3 = class1.getMethod("getAge");
        Object obj0 = method3.invoke(obj);
//        System.out.println(obj0);
    }

    private static void getFileds() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //        使用反射动态操作属性值
        Class<?> class1 = Class.forName("com.entity.Student");
        System.out.println("=========本类的属性==============");
        //获得所有的属性
        Field[] fields = class1.getDeclaredFields();
        for (Field fi :
                fields) {
            //修饰符
            String pri = Modifier.toString(fi.getModifiers());

            //类型
            String type = fi.getType().getName();

            //属性名
            String name = fi.getName();

            System.out.println(pri + "\t" + type + "\t" + name);
        }

//        可以修改权限来给private,protected赋值
        //创建对象  Student obj = new Student();
        Object obj = class1.newInstance();
        //获得属性
        Field field = class1.getDeclaredField("name");
//        Exception in thread "main" java.lang.IllegalAccessException: Class com.hlx.Test1 can not access a member of class com.entity.Student with modifiers "protected"
        //解决重新设置权限
        field.setAccessible(true);
        //直接赋值  obj具体对象  obj.setName(name);
        field.set(obj, "曼克");
        System.out.println(field.get(obj));
    }

    private static void getConstructor() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //        使用反射动态创建对象

//        方法一：使用Class的newInstance()方法，仅适用于无参构造方法
//        1）获取 Class对象的方式
        Class<?> class1 = Class.forName("com.entity.Student");
        //2>对象
        Object obj = class1.newInstance();
        //3>强制类型转换
        Student stu = (Student) obj;
        stu.setName("mike");
        stu.setAge(20);
        System.out.println(obj);

        //  方法二：调用Constructor的newInstance()方法，适用所有构造方法
        //构造方法的参数:类的类型int.class,Double.class...
        Constructor con = class1.getConstructor(new Class[]{int.class, String.class});
        //实例化对象
        Object obj2 = con.newInstance(new Object[]{18, "何伟"});
        System.out.println(obj2);
    }

    private static void getClasses() throws ClassNotFoundException {
        //  1）获取 Class对象的方式
        //方法1：对象.getClass()
        Class<?> class1 = new Test1().getClass();

        //方法2：类.class
        Class<?> class2 = Test1.class;

        //*方法3：Class.forName();
        Class<?> class3 = Class.forName("com.hlx.Test1");

        System.out.println(class1.getName());
        System.out.println(class2.getName());
        System.out.println(class3.getName());
    }
}
