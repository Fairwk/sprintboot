package day20211109;

public class MyCircularQueue {
    private int[] elem;//数组
    private int front;//头
    private int rear;//尾巴下标  当前可以存放元素的下标

    public MyCircularQueue(int k){
        this.elem = new int[k+1];
        //这里面为什么是k+1 ,因为题上的描述是放k个我们实现的是k-1所以必须加1
        this.front = 0;
        this.rear = 0;
    }
    //入队
    public boolean enQueue(int value){
        if(isFull()) return false;
        this.elem[this.rear] = value;
        this.rear = (this.rear+1)%this.elem.length;
        return true;

    }
    //出队
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        this.front = (this.front+1) % this.elem.length;
        return true;
    }
    //得到队头元素
    public int Front(){
        if(isEmpty()){
            return -1;
        }
        return this.elem[this.front];
    }
    //得到队尾元素
    public int Rear(){
        if(isEmpty()){
            return -1;
        }
        int index = (this.rear == 0) ? this.elem.length-1 : this.rear-1;
        return this.elem[index];
    }

    public boolean isEmpty(){
        //只要他们两相遇就是空
        if(this.front == this.rear){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if((this.rear+1) % this.elem.length == this.front){
            return true;
        }
        return false;
    }
}
