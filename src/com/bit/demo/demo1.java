package com.bit.demo;

 class Animal{
    protected String name;
    public Animal(String name){
        this.name = name;
        System.out.println("Animal(String)");
    }
    public void eat(){
        System.out.println(this.name+"Animal::eat()");
    }

    public void sleep(){
        System.out.println("Animal::sleep()");
    }
}

class Cat extends Animal {
    public Cat(String name){
        super(name);

        System.out.println("Cat(String)");
    }
    /*public String name;
    public void eat(){
        System.out.println("Cat::eat()");
    }*/
}
class chineseGardenCat extends Cat{

    public chineseGardenCat(String name) {
        super(name);
    }
}
class Bird extends Animal{

    public Bird(String name) {
        super(name);
    }

    public void fly(){
        System.out.println(this.name+"Bird::fly()");
    }
    /*public String name;
    public void eat(){
        System.out.println("Bird::eat()");
    }*/

}

public class demo1 {
    public static void main(String[] args) {
        chineseGardenCat chineseGardenCat = new chineseGardenCat("haha");
        chineseGardenCat.eat();
    }
    public static void main1(String[] args) {
        Cat cat = new Cat("mini");
        cat.eat();
        Bird bird = new Bird("八哥");
        bird.fly();

    }
}
