package generic;
/*
泛型的意义:
1.存数据的时候,进行类型检查
2.取数据的时候,进行类型的自动转换
泛型先检查后编译
泛型的坑:
1.不能new泛型类型的数组 T[] t = new T[];因为他是先检查后编译的;
当检查时,还不知道这个T是谁,编译的时候,类型的擦除-->Object
泛型是怎么编译的?
泛型是在编译时期的一种机制.这种机制叫做: 类型擦除机制.
编译的时候,会把这个泛型参数,擦除为Object(只是在当前类中,类外是直接被擦除掉)

 */
class Stack<T>{
    public T[] objects;
    public int top;
    public Stack(){
        //this.objects = new T[10];
        this.objects = (T[])new Object[10];
    }
    public void push(T obj){
        objects[this.top++] = obj;
    }
    public T get(){
      return objects[this.top-1];
    }
}
public class TestDemo {
    public static void main(String[] args) {
       Stack<Integer> stack = new Stack<>();
       stack.push(1);
       stack.push(2);
       //stack.push("bit");
        int ret = stack.get();
        System.out.println(ret);
        /*
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push("bit");
        String str = (String) stack.get();
         */

    }
}
