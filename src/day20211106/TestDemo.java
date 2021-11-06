package day20211106;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//最小栈
class MinStack{
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val){
        //普通的栈 一定要放元素
        stack.push(val);
        if(minStack.empty()){
            minStack.push(val);
        }else{
            //1.获取当前最小栈顶元素
            int top = minStack.peek();
            //2.谁小谁就要放进来
            if(val <= top){//-4 < -2 就得放进minStack中
                minStack.push(val);
            }
        }
    }
    public void pop(){
        int val = stack.pop();
        if(!minStack.empty()){
            int top = minStack.peek();
            if(val == top){
                minStack.pop();
            }
        }
    }
    public int top(){
        //根据看人家示例,发现获取的是欧通栈顶元素
        if(stack.empty()){
            return -1;
        }
        return stack.peek();
    }
    public int getMin(){
        if(minStack.empty()){
            return -1;
        }
        return minStack.peek();
    }
}
public class TestDemo {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.peek());//1
        System.out.println(myQueue.poll());//1
        System.out.println(myQueue.poll());//2
        System.out.println(myQueue.poll());//3
        System.out.println(myQueue.isEmpty());//true
        System.out.println(myQueue.poll());


    }
    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.peek());//1 得到队头元素 但不出队
        System.out.println(queue.poll());//1 出队
        System.out.println(queue.poll());//2 出队
        //LinkedList<Integer> linkedList = new LinkedList<>();
    }

}
