package day20211107;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class MyStack{
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    public MyStack(){
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }
    public void push(int x){
        if(!qu1.isEmpty()){
            qu1.offer(x);
        }else if(!qu2.isEmpty()){
            qu2.offer(x);
        }else{
            //当两个队列都为空时,目前指定放到第一个队列中去
            qu1.offer(x);
        }
    }
    public int pop(){
        if(empty()){
            return -1;
        }
        if(!qu1.isEmpty()){
            int size = qu1.size();
            for(int i = 0 ;i < size-1; i++){
                int x = qu1.poll();
                qu2.offer(x);
            }
            return qu1.poll();
        }else{
            int size = qu2.size();
            for(int i = 0 ;i < size-1; i++){
                int x = qu2.poll();
                qu1.offer(x);
            }
        }
        return qu2.poll();
    }
    public int top(){
        if(empty()) return -1;
        if(!qu1.isEmpty()){
            int size = qu1.size();
            int x = -1;
            for(int i = 0;i < size; i++){
                x = qu1.poll();
                qu2.offer(x);
            }
            return x;
        }else{
            int size = qu2.size();
            int x = -1;
            for(int i = 0;i < size; i++){
                x = qu2.poll();
                qu1.offer(x);
            }
            return x;
        }
    }
    public boolean empty(){
        return qu1.isEmpty() && qu2.isEmpty();
    }
}

public class StackQueueOj {
    //括号匹配问题
    public static boolean isValid(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        //1.定义一个栈,来存放左括号
        Stack<Character> stack = new Stack<>();
        //2.开始遍历当前字符串s
        for(int i = 0; i < s.length(); i++){
            //获取当前i下标是一个什么字符
            char ch = s.charAt(i);
            //判断当前的字符是哪种左括号,因为题上有三种
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                //进入else 说明当前i下标是一个右括号
                //这时判断一下栈空不空
                if(stack.empty()){
                    System.out.println("右括号多! ");
                    return false;
                }
                //获取栈顶元素的括号,但是先别出栈
                char tmp = stack.peek();
                //判断是否匹配 如果匹配出栈
                if(tmp == '{' && ch == '}' || tmp == '[' && ch == ']' || tmp == '(' && ch == ')'){
                    //出栈当前的左括号 说明匹配成功
                    stack.pop();
                }else{
                    System.out.println("左右括号不匹配! ");
                    return false;
                }
            }
        }
        //把字符串都遍历完了 但是栈还不为空
        if(!stack.empty()){
            System.out.println("左括号多! ");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        System.out.println("The result is : " + isValid(string));
    }
}
