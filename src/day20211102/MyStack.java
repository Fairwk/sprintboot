package day20211102;

import java.util.Arrays;

public class MyStack<T> {
    private T[] elem;//数组
    private int top;//下标  也叫栈顶指针

    public MyStack(){
        this.elem = (T[])new Object[10];
    }

    /*
    入栈操作
    item : 入栈的元素
    return : 入栈的元素
     */
    public void push(T item){
        //1.判断当前栈是否是满的
        /*if(this.top == this.elem.length){
            return;
        }
        */
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.top++] = item;//先把item赋给top,top再++
    }
    public boolean isFull(){
        return this.elem.length == this.top;
    }

    /*
    出栈
    return : 出栈的元素
     */
    public T pop(){
        if(empty()){
            throw new UnsupportedOperationException("栈为空! ");
        }
        T ret = this.elem[this.top-1];//这里的top还在原位置并没有减1 只是取了减一下标的元素
        this.top--;//真正改变了top的值
        return ret;
    }
    /*
    得到栈顶元素但不出栈
     */
    public T peek(){
        if(empty()){
            throw new UnsupportedOperationException("栈为空! ");
        }
        T ret = this.elem[this.top-1];//这里的top还在原位置并没有减1 只是取了减一下标的元素
        //this.top--;//真正改变了top的值
        return ret;
    }
    /*
    判断栈是否为空
     */
    public boolean empty(){

        return this.top == 0;
    }
}
