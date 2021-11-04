package day20211102;

import java.util.Stack;

public class TestDemo {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());//3
        System.out.println(myStack.pop());//3
        System.out.println(myStack.pop());//2
        System.out.println(myStack.pop());//1
        System.out.println(myStack.empty());

        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("hello");
        myStack2.push("kun");
        myStack2.push("cool");
        System.out.println(myStack2.peek());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.empty());
    }
    public static void main2(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());//3
        System.out.println(myStack.pop());//3
        System.out.println(myStack.pop());//2
        System.out.println(myStack.pop());//1
        System.out.println(myStack.empty());//true


    }
    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);//再栈里添加元素 入栈
        stack.push(2);
        stack.push(3);
        //1 2 3
        int ret = stack.pop();//删除栈顶的元素 出栈
        System.out.println(ret);

        int ret2 = stack.peek();//得到栈顶的元素但是不删除(不出栈)
        System.out.println(ret2);

        boolean flg = stack.empty();//判断栈是否为空
        System.out.println(flg);

    }
}
