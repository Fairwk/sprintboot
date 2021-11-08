package day20211108;

public class WolfDog2 {
    String name;
    int age;
    String color;
    //无参构造函数
    public WolfDog2(){

    }
    //无参数返回方法
    public void bark(){
        System.out.println("WolfDog bark");
    }
    //有参数有返回值的方法
    public String barkReturn (String name){
        System.out.println("WolfDog bark Named " + name);
        return name;
    }

    public static void main(String[] args) {
        WolfDog2 dog = new WolfDog2();
        dog.bark();
        String name1 = "teddy";
        String name2 = dog.barkReturn(name1);
        System.out.println(name2);
    }
}
