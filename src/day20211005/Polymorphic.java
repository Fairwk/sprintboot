package day20211005;

class Animal{
    public String name;
    public Animal(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println(this.name + "正在吃Animal");
    }
}
class Cat extends Animal{
    public String huzi;

    public Cat(String name,String huzi){
        super(name);
        this.huzi = huzi;
    }
    public void eat(){
        System.out.println(this.name + "正在吃Cat");
    }

    public void func(){
        System.out.println(this.name);
    }
}
public class Polymorphic {
    public static void main(String[] args) {
        //父类引用子类  引用子类对象 向上转型
        Animal animal = new Cat("初一","胡子");
        animal.eat();
       // Cat cat = new Cat();
        //cat.eat();

    }

}
