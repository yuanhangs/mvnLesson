package com.hlx;

/**
 * 水果接口
 */
public interface Fruit {
    public void eat();
}

class  Watermelon implements  Fruit{

    @Override
    public void eat() {
        System.out.println("西瓜！");
    }
}


class  Apple implements  Fruit{

    @Override
    public void eat() {
        System.out.println("苹果！");
    }
}
// 工厂
class FruitFactory{
    public static Fruit getInstance(String type){
        Fruit  fruit=null;
//        switch (type){
//            case "apple":
//                fruit =new Apple();
//                break;
//            case "watermelon":
//                fruit =new Watermelon();
//                break;
//        }

        try {
            //通过反射机制实例化对象
          fruit = (Fruit) Class.forName(type).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fruit;
    }
}

class Test{
    public static void main(String[] args) {
        FruitFactory.getInstance("com.hlx.Apple").eat();
        FruitFactory.getInstance("com.hlx.Watermelon").eat();
    }
}

//查询语句 返回Result，方式不好，
// 最后使用反射！！！，修改这个方法，返回List<T>