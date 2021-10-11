package day20211005;

abstract class Shapes {
    public abstract void draw();
}
class Cyc extends Shapes{
    @Override
    public void draw(){
        System.out.println("画一个○");
    }
}

class Rect extends Shapes{
    @Override
    public void draw(){
        System.out.println("画一个♦");
    }
}

public class Abstract {
    public static void main(String[] args) {

    }
}
