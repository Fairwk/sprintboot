package day20211108;

public class WolfDog1 {
    String name;
    int age;
    String color;
    public void bark(){
        System.out.println("WolfDog named " + name + " dress " + color + " is bark at age " + age + ".");
    }

    public static void main(String[] args) {
        WolfDog1 teddyDog = new WolfDog1();
        teddyDog.name = "一阳";
        teddyDog.age = 12;
        teddyDog.color = "black";
        teddyDog.bark();
    }
}
