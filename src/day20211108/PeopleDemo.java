package day20211108;
class People{
    private String name;
    private int age;
    public int num;
    //根据姓名,年龄和编号初始化对象
    public People (String name,int age,int num){
        this.name = name;
        this.age = age;
        this.num = num;
    }
    //获取姓名

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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "People [name = " + name + ",age = " + age + ", num = " + num +" ]";
    }
}
public class PeopleDemo {
    public static void main(String[] args) {
        People person = new People("王一阳",20,100);
        System.out.println(person.toString());
        person.num = 200;
        System.out.println(person.toString());
        person.setAge(50);
        System.out.println(person.toString());
        System.out.println(person.getAge());
    }
}
