package day20211108;
interface Shape {
    static final float PI=3.14F;
    public abstract float getPerimeter();
    public abstract float getArea();
}

class Rectangle implements Shape {    //长方形子类
    private float length;
    private float width;
    public Rectangle(float length,float width){
        this.length=length;
        this.width=width;
    }
    public float getPerimeter(){  //重写父类方法
        return (length+width)*2;
    }
    public float getArea(){   //重写父类方法
        return length*width;
    }
}

class Circle implements Shape {    //圆子类
    private float radius;
    public Circle(float r){
        radius=r;
    }
    public float getPerimeter(){  //重写父类方法
        return 2*PI*radius;
    }
    public float getArea(){  //重写父类方法
        return PI*radius*radius;
    }
}

public class AbstractTest {
    public static void main(String[] args){
        Rectangle rect=new Rectangle(2,3);   //创建对象
        Circle c=new Circle(3);
        System.out.println("长方形的周长是："+rect.getPerimeter()+",面积是："+rect.getArea());
        System.out.println("圆的周长是："+c.getPerimeter()+",面积是："+c.getArea());
    }
}
