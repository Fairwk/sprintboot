package day20210922;

class Person{
    private String name;
    private int age;
    private static int count;

    public Person(){
        System.out.println("Person(init)");
    }

    public Person (String name,int age){
        this.name = name;
        this.age = age;
        System.out.println(name);
        System.out.println(age);
    }
    {
        this.name = "zhang fei";
        count  = 99;
        System.out.println("实例代码块.......");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestDemo0922 {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("bit",19);
    }

}
