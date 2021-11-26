package innerclass;
class OuterClass{
    public int data1 = 1;
    public int data2 = 2;
    public static int data3 = 3;
    public void func(){
        System.out.println("OuterClass::func()");
    }
    /*
    实例内部类
    可以把实例内部类 当做就是一个实例成员变量
    1. 不能定义静态的成员变量.原因: 静态的成员变量不依赖于对象
    如果非要定义,可以定义为static final 也就是说 只要在编译期间能确定值就可以了
    2.如何在其他类 拿到一个实例内部类的对象
    OuterClass outerClass = new OuterClass();
    OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    外部类.内部类 变量名 = 外部类对象的引用.new.内部类()
    3.实例内部类当做如何访问外部类的同名成员变量
    OuterClass.this.data1
    外部类.this.data
    4.内部类的字节码文件
    外部类$内部类.class

    class InnerClass{
        public int data1 = 1000;
        public int data4 = 4;
        private int data5 = 5;
        //public static int data6 = 6;
        public static final int data6 = 6;
        public void functionInner(){
            System.out.println("InnerClass::funcInner");
            System.out.println(this.data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(OuterClass.this.data1);
        }
    }

     */
    /*
    静态内部类:
    可以把静态内部类 当做就是一个静态成员
    1. 如何拿到静态内部类的对象
     */
    static class InnerClass{
        public int data1 = 1000;
        public int data4 = 4;
        private int data5 = 5;
        public static int data6 = 6;
        //public static final int data6 = 6;
        public void functionInner(){

        }
    }
}
public class TestDemo {
    public static void main(String[] args) {

    }
    /*public static void main(String[] args) {
        //这种写法也行
        OuterClass.InnerClass innerClass2 = new OuterClass().new InnerClass();
        innerClass2.functionInner();
    }
    public static void main1(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    }
*/


}
