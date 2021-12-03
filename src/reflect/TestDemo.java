package reflect;

class Student{
    //私有属性name
    private String name = "bit";
    //公有属性age
    public int age = 18;
    //不带参数的构造方法
    public Student(){
        System.out.println("Student()");
    }
    private Student(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(String,name)");
    }
    private void eat(){
        System.out.println("i am eat");
    }
    public void sleep(){
        System.out.println("i am pig");
    }
    private void function(String str) {
        System.out.println(str);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        Class对象只有一个
         */
        /*
        1.通过getClass获取Class对象
        */
        Student s1 = new Student();
        Class c1 = s1.getClass();
        /*
        2.直接通过 类名.class 的方式得到,该方法最为安全可靠，程序性能更高
        这说明任何一个类都有一个隐含的静态成员变量 class
        */
        Class c2 = Student.class;
        /*
        3、通过 Class 对象的 forName() 静态方法来获取，用的最多，
        但可能抛出 ClassNotFoundException 异常
        */
        Class c3 = null;
        try {
             c3 = Class.forName("reflect.Student");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c2.equals(c3));

    }
}
