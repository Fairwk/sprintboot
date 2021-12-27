package day20211227;
abstract class Shape{
    double len,width,radius;
    public Shape(){

    }


    public abstract double Area();
    public abstract double Perimeter();
}
class Circle extends Shape{
    public Circle(double radius){
       this.radius = radius;
    }
    public double Area(){
        return Math.PI * radius * radius;
    }
    public double Perimeter(){
        return 2*Math.PI*radius;
    }
}
class Rectangle extends Shape{
    public Rectangle(double len,double width){
        this.len = len;
        this.width = width;
    }
    public double Area(){
        return len*width;
    }
    public double Perimeter(){
        return (len+width)*2;
    }
}
public class TestShape {
    public static void main(String[] args) {
        Circle ci = new Circle(5.5);
        Rectangle re = new Rectangle(5,7.8);
        System.out.println("圆的面积: " + ci.Area());
        System.out.println("圆的周长: " + ci.Perimeter());
        System.out.println("长方形的面积: " + re.Area());
        System.out.println("长方形的周长: " + re.Perimeter());
    }


}
