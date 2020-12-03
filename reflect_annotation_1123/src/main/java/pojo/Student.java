package pojo;

public class Student {
    private String name;
    /**
     * 构造方法
     * @param name
     * @param age
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
    protected String address="HZ";
    public  int count=100;

    /**
     * 无参的方法
     */
    public void show() throws NumberFormatException, Exception{
        System.out.println("测试反射！");
    }

    /**
     * 有参数的方法
     * @param name
     * @param age
     */
    public void display(String name,int age){
        System.out.println(name+"测试反射！==>"+age);
    }
}
